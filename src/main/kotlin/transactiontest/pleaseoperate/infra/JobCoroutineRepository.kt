package transactiontest.pleaseoperate.infra

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import transactiontest.pleaseoperate.domain.entity.job.Job

interface JobCoroutineRepository : CoroutineCrudRepository<Job, String> {
    suspend fun findFirstByName(name: String): Job
}