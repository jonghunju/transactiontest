package transactiontest.pleaseoperate.domain

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JobService(
    private val jobRepository: JobRepository
) {


    @Transactional
    suspend fun rollback() {
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
    }

    @Transactional
    suspend fun dirtyCheck():String{
        val job = jobRepository.findByName("job1")

        job.changeName("changed")

        return "success"
    }


}