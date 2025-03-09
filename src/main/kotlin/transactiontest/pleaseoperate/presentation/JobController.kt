package transactiontest.pleaseoperate.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import transactiontest.pleaseoperate.application.JobFacade

@RestController
class JobController(
    private val jobFacade: JobFacade
) {

    @PostMapping("/please")
    suspend fun please(){
        jobFacade.please()
    }
}