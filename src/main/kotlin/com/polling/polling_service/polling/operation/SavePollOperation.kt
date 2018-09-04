package com.polling.polling_service.polling.operation

import com.polling.polling_service.polling.poll.web.InputPoll
import com.polling.polling_service.polling.poll.web.InputQuestion
import com.polling.polling_service.polling.common.UniqueIdGenerator
import com.polling.polling_service.polling.link.LinkDocument
import com.polling.polling_service.polling.link.LinkRepository
import com.polling.polling_service.polling.poll.domain.OutputPoll
import com.polling.polling_service.polling.poll.domain.PollDocument
import com.polling.polling_service.polling.poll.domain.PollRepository
import com.polling.polling_service.polling.question.domain.QuestionDocument
import com.polling.polling_service.polling.question.domain.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SavePollOperation : ISavePollOperation {
    @Autowired
    lateinit var questionRepository: QuestionRepository

    @Autowired
    lateinit var linkRepository: LinkRepository

    @Autowired
    lateinit var pollRepository: PollRepository

    override fun perform(inputPoll: InputPoll, link: String): OutputPoll {
        val link = this.getLink(inputPoll.name)
        val poll = this.getPoll(inputPoll, link.id)

        questionRepository.saveAll(this.getQuestions(inputPoll.questions, poll.id))
        linkRepository.save(link)
        pollRepository.save(poll)
        return OutputPoll(poll.id, link.path)
    }

    private fun getLink(name: String): LinkDocument {
        return LinkDocument(UniqueIdGenerator.byName(name), "some-random-path")
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
            QuestionDocument (
                    UniqueIdGenerator.byTime(),
                    q.shortText,
                    q.description,
                    pollID,
                    "SCORE"
            )
        }
    }

}
