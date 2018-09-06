package com.polling.polling_service.poll.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PollRepository : CrudRepository<PollDocument, UUID>