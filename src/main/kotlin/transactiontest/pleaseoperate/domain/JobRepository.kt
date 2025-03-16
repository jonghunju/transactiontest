package transactiontest.pleaseoperate.domain

interface JobRepository {
    suspend fun save(job:Job)
}