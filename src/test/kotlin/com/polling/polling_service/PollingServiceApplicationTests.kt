package com.polling.polling_service

import com.polling.polling_service.poll.web.InputPoll
import com.polling.polling_service.poll.web.InputQuestion
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.core.Is.`is`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PollingServiceApplicationTests {

	@LocalServerPort
	val port: Int = 0

	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun contextLoads() {
		val response = testRestTemplate.getForEntity("http://localhost:$port/", String::class.java)
		assertThat(response.body, `is`("Hello World!"))
		assertThat(response.statusCode, `is`(HttpStatus.OK))
	}

	@Test
	fun testForCreatePoll() {
		val questions: List<InputQuestion> = listOf<InputQuestion>(
				InputQuestion("Food", "How would you rate food over here?", "SCORE"),
				InputQuestion("Service", "How would you service over here?", "SCORE"),
				InputQuestion("Ambiance", "How would you ambiance over here?", "SCORE")
		)
		val request: HttpEntity<InputPoll> = HttpEntity(InputPoll("Customer Survey", "A feedback form for customer", questions))
		val response = testRestTemplate.postForEntity("http://localhost:$port/poll", request,  String::class.java)

		assertThat(response.statusCode, `is`(HttpStatus.CREATED))
	}


}
