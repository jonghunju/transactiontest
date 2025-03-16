package transactiontest.pleaseoperate.domain.service.job

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import transactiontest.pleaseoperate.domain.entity.job.Job
import transactiontest.pleaseoperate.domain.repo.job.JobRepository

@Service
class JobService(
    private val jobRepository: JobRepository
) {


    @Transactional
    suspend fun please() {
        runCatching {
            val job1 = Job(
                id = ObjectId.get().toHexString(),
                name = "job1"
            )
            val job2 = Job(
                id = ObjectId.get().toHexString(),
                name = "job2"
            )
            jobRepository.save(job1)
            jobRepository.save(job2)
            throw RuntimeException("제발 롤백 되자.")
        }.fold(
            onSuccess = {},
            onFailure = { throw it }
        )
    }


}