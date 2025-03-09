package transactiontest.pleaseoperate.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@DisplayName("트랜잭션 통합테스트")
class TransactionTest(
    @Autowired private val jobFacade: JobFacade
) {

//    @Test
//    suspend fun `트랜잭션 테스트`() {
//        jobFacade.please()
//    }

}