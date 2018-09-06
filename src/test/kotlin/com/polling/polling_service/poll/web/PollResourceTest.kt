package com.polling.polling_service.poll.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.polling.polling_service.PollingServiceApplication
import com.polling.polling_service.poll.domain.OutputPoll
import com.polling.polling_service.poll.domain.PollService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@WebMvcTest(PollResource::class)

class PollResourceTest {
    @MockBean
    lateinit var pollService: PollService

    @Autowired
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper


    @Test
    fun shouldCreatePoll() {
        val questions: List<InputQuestion> = listOf(
                InputQuestion("Food", "How would you rate food over here?", "SCORE"),
                InputQuestion("Service", "How would you service over here?", "SCORE"),
                InputQuestion("Ambiance", "How would you ambiance over here?", "SCORE")
        )
        val inputPoll = InputPoll("Customer Survey", "A feedback form for customer", questions)
        val outputPoll = OutputPoll("random ID", "unique-link")
        val expectedResult = mapper.writeValueAsString(outputPoll)

        `when`(pollService.createPoll(inputPoll)).thenReturn(outputPoll)
        mvc.perform(
                MockMvcRequestBuilders.post("/poll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(inputPoll)))
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedResult))
                .andReturn()
//        assertThat(result.response.contentAsString, `is`(expectedResult))
    }
}
