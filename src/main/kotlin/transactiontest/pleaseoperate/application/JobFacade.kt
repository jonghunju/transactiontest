package transactiontest.pleaseoperate.application

import org.springframework.stereotype.Component
import transactiontest.pleaseoperate.domain.service.job.JobService

@Component
class JobFacade(
    private val jobService: JobService
) {
    suspend fun rollback() {
        runCatching {
            jobService.rollback()
        }.fold(
            onSuccess = {
                println("성공하면 안되는데?")
            },
            onFailure = { println("의도된 Exception. ${it.message}") }
        )
    }

    suspend fun dirtyCheck(): String {
        return jobService.dirtyCheck()
    }
}