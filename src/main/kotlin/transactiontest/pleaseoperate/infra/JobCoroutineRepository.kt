package transactiontest.pleaseoperate.infra

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import transactiontest.pleaseoperate.domain.Job

interface JobCoroutineRepository:CoroutineCrudRepository<Job,String> {
}