package transactiontest.pleaseoperate.domain.repo.board

import transactiontest.pleaseoperate.domain.entity.board.Board

interface BoardRepository {
    suspend fun save(board:Board): Board
    suspend fun findById(id:String): Board
}