package transactiontest.pleaseoperate.domain.entity.board

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "board")
data class Board(
    @Id val id: String,
    val name:String
) {}