package transactiontest.pleaseoperate.infra

import org.springframework.stereotype.Repository
import transactiontest.pleaseoperate.domain.entity.job.Job
import transactiontest.pleaseoperate.domain.repo.job.JobRepository

@Repository
class JobRespositoryImpl(
    private val jobCoroutineRepository:JobCoroutineRepository
): JobRepository {
    override suspend fun save(job: Job) {
        jobCoroutineRepository.save(job)
        println("save")
    }
}