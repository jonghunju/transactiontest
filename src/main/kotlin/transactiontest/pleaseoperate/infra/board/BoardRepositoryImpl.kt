package transactiontest.pleaseoperate.infra.board

import org.springframework.stereotype.Repository
import transactiontest.pleaseoperate.domain.entity.board.Board
import transactiontest.pleaseoperate.domain.repo.board.BoardRepository

@Repository
class BoardRepositoryImpl(
    private val boardCoroutineRepository: BoardCoroutineRepository
) : BoardRepository {
    override suspend fun save(board: Board): Board {
        return boardCoroutineRepository.save(board)
    }

    override suspend fun findById(id: String): Board {
        return boardCoroutineRepository.findById(id)
            ?: throw IllegalArgumentException("해당하는 Board 없음.")
    }


}