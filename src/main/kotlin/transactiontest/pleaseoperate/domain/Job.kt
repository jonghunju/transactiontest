package transactiontest.pleaseoperate.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "job")
class Job(
    @Id
    var id: String,
    var name: String
) {

    fun changeName(name:String){
        this.name= name
    }
}