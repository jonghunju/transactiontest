package transactiontest.pleaseoperate.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "job")
class Job(
    @Id
    val id: String,
    val name: String
) {
}