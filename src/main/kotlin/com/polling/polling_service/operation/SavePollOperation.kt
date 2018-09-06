package com.polling.polling_service.operation

import com.polling.polling_service.common.UniqueIdGenerator
import com.polling.polling_service.link.domain.LinkDocument
import com.polling.polling_service.link.domain.LinkRepository
import com.polling.polling_service.poll.domain.OutputPoll
import com.polling.polling_service.poll.domain.PollDocument
import com.polling.polling_service.poll.domain.PollRepository
import com.polling.polling_service.poll.web.InputPoll
import com.polling.polling_service.poll.web.InputQuestion
import com.polling.polling_service.domain.QuestionDocument
import com.polling.polling_service.domain.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("SavePollOperation")
class SavePollOperation : ISavePollOperation {
    @Autowired
    lateinit var questionRepository: QuestionRepository

    @Autowired
    lateinit var linkRepository: LinkRepository

    @Autowired
    lateinit var pollRepository: PollRepository

    override fun perform(inputPoll: InputPoll, link: String): OutputPoll {
        val link = this.getLink(link)
        val poll = this.getPoll(inputPoll, link.id)

        questionRepository.saveAll(this.getQuestions(inputPoll.questions, poll.id))
        linkRepository.save(link)
        pollRepository.save(poll)
        return OutputPoll(poll.id, link.longURL)
    }

    private fun getLink(uniquePath: String): LinkDocument {
        return LinkDocument(
                uniquePath,
                "/polls/$uniquePath")
    }

    private fun getPoll(inputPoll: InputPoll, linkID: String): PollDocument {
        return PollDocument(
                UniqueIdGenerator.byName(inputPoll.name),
                inputPoll.name,
                inputPoll.description,
                linkID
        )
    }

    private fun getQuestions(questions: List<InputQuestion>, pollID: String): List<QuestionDocument> {
        return questions.map { q ->
            QuestionDocument(
                    UniqueIdGenerator.byTime(),
                    q.shortText,
                    q.description,
                    pollID,
                    "SCORE"
            )
        }
    }

}
