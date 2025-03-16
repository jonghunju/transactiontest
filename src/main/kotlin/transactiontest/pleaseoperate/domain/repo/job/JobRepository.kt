package transactiontest.pleaseoperate.domain.repo.job

import transactiontest.pleaseoperate.domain.entity.job.Job

interface JobRepository {
    suspend fun save(job: Job)
}