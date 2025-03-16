package transactiontest.pleaseoperate.bdd.board

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import transactiontest.pleaseoperate.application.BoardFacade
import transactiontest.pleaseoperate.domain.entity.board.Board
import transactiontest.pleaseoperate.domain.repo.board.BoardRepository
import transactiontest.pleaseoperate.domain.service.board.BoardService

class BoardFeatureTest : BehaviorSpec({
    // 모의 객체(Repository)를 relaxed 모드로 생성.
    val boardRepository = mockk<BoardRepository>(relaxed = true)
    val boardService = BoardService(boardRepository)
    val boardFacade = BoardFacade(boardService)

    // boardRepository.save() 호출 시, 전달받은 Board에 id "board1"을 부여하여 반환하도록 스텁 설정
    coEvery { boardRepository.save(any()) } answers {
        val boardArg = firstArg<Board>()
        boardArg.copy(id = "board1")
    }

    // boardRepository.findById("board1") 호출 시, 처음에는 조회수 0, 다음에는 1인 Board 객체를 순차적으로 반환하도록 설정
    coEvery { boardRepository.findById("board1") } returnsMany listOf(
        Board(id = "board1", name = "테스트게시글1", viewCount = 0),
        Board(id = "board1", name = "테스트게시글1", viewCount = 1)
    )

    Given("게시글을 하나 만들고") {
        // 게시글 생성 유스케이스 호출
        val board1 = boardFacade.createBoard("테스트게시글1")
        When("게시글을 한 번 조회하면") {
            // 게시글 조회 유스케이스 호출 시 내부에서 조회수가 증가한다고 가정
            val boardAfterView = boardFacade.getBoard(board1.id)
            Then("조회수 결과는 1이 되어야 한다") {
                boardAfterView.viewCount shouldBe 1
            }
        }
    }
})
