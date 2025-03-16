package transactiontest.pleaseoperate.domain.dto.board

import org.bson.types.ObjectId
import transactiontest.pleaseoperate.domain.entity.board.Board

data class CreateBoardCommand(
    val name: String
) {
    companion object {
        fun toEntity(command: CreateBoardCommand): Board {
            return Board(
                id = ObjectId.get().toHexString(),
                name = command.name
            )
        }
    }
}