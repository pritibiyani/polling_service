package com.polling.polling_service.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface QuestionRepository:CrudRepository<QuestionDocument, UUID> {
}