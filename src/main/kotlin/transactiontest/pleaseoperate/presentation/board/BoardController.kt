package transactiontest.pleaseoperate.presentation.board

import org.springframework.web.bind.annotation.*
import transactiontest.pleaseoperate.application.BoardFacade
import transactiontest.pleaseoperate.domain.entity.board.Board

@RestController
@RequestMapping("/board")
class BoardController(
    private val boardFacade: BoardFacade
) {
    @GetMapping("")
    suspend fun getBoard(@RequestParam id: String): Board {
        return boardFacade.getBoard(id)
    }

    @PostMapping
    suspend fun createBoard(@RequestBody name: String): Board {
        return boardFacade.createBoard(name)
    }
}
