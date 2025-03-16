package transactiontest.pleaseoperate.domain.service.board

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import transactiontest.pleaseoperate.domain.dto.board.CreateBoardCommand
import transactiontest.pleaseoperate.domain.dto.board.CreateBoardCommand.Companion.toEntity
import transactiontest.pleaseoperate.domain.entity.board.Board
import transactiontest.pleaseoperate.domain.repo.board.BoardRepository

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {


    @Transactional
    suspend fun create(command: CreateBoardCommand):Board{
        return boardRepository.save(toEntity(command))

    }
    @Transactional
    suspend fun getBoard(id:String):Board{
        val board = boardRepository.findById(id)
        board.increaseViewCount()
        return boardRepository.save(board)
    }
}