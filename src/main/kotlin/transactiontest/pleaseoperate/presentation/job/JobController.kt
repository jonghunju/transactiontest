package transactiontest.pleaseoperate.presentation.job

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import transactiontest.pleaseoperate.application.JobFacade

@RestController("/job")
class JobController(
    private val jobFacade: JobFacade
) {

    @PostMapping("/rollback")
    suspend fun rollback(){
        jobFacade.rollback()
    }

    @GetMapping("/dirtyCheck")
    suspend fun dirtyCheck():String{
        return jobFacade.dirtyCheck()
    }
}