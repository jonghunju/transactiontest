package transactiontest.pleaseoperate.application

import org.springframework.stereotype.Component
import transactiontest.pleaseoperate.domain.dto.board.CreateBoardCommand
import transactiontest.pleaseoperate.domain.entity.board.Board
import transactiontest.pleaseoperate.domain.service.board.BoardService

@Component
class BoardFacade(
    private val boardService: BoardService
) {

    suspend fun createBoard(name: String):Board {
        return boardService.create(CreateBoardCommand(name))
    }

    suspend fun getBoard(id: String): Board {
        return boardService.getBoard(id)
    }

}

