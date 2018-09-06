package com.polling.polling_service.poll.domain

import com.polling.polling_service.operation.SavePollOperation
import com.polling.polling_service.poll.web.InputPoll
import com.polling.polling_service.poll.web.InputQuestion
import org.joda.time.DateTime
import org.joda.time.DateTimeUtils
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PollServiceTest {
    @Autowired
    lateinit var pollService: PollService

    @MockBean
    lateinit var savePollOperation: SavePollOperation

    @Test
    fun shouldCallSavePollOperationWithCustomLinkGenerated() {
        val fixedDate = DateTime(
                2018,
                9,
                5,
                0,
                0,
                0,
                0).millis
        DateTimeUtils.setCurrentMillisFixed(fixedDate)

        val outputPoll = OutputPoll("unique-poll-id", "unique-link-id")
        val inputPoll = getInputPoll()

        val expectedLink = "24113390349ec2af8923cefd70af5b55"
        Mockito.`when`(savePollOperation.perform(inputPoll, expectedLink)).thenReturn(outputPoll)

        pollService.createPoll(inputPoll)

        DateTimeUtils.setCurrentMillisSystem()
        verify(savePollOperation, times(1)).perform(inputPoll, expectedLink)
    }

    private fun getInputPoll(): InputPoll {
        val questions: List<InputQuestion> = listOf(
                InputQuestion("Food", "How would you rate food over here?", "SCORE"),
                InputQuestion("Service", "How would you service over here?", "SCORE"),
                InputQuestion("Ambiance", "How would you ambiance over here?", "SCORE")
        )
        return InputPoll("Customer Survey", "A feedback form for customer", questions)
    }
}