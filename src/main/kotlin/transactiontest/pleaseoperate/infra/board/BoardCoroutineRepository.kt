package transactiontest.pleaseoperate.infra.board

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import transactiontest.pleaseoperate.domain.entity.board.Board

interface BoardCoroutineRepository: CoroutineCrudRepository<Board,String> {

    suspend fun save(board: Board): Board
}