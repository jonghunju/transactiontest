package transactiontest.pleaseoperate.infra

import org.springframework.stereotype.Repository
import transactiontest.pleaseoperate.domain.Job
import transactiontest.pleaseoperate.domain.JobRepository

@Repository
class JobRespositoryImpl(
    private val jobCoroutineRepository:JobCoroutineRepository
): JobRepository {
    override suspend fun save(job: Job) {
        jobCoroutineRepository.save(job)
        println("save")
    }
}