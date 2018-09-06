package com.polling.polling_service.link.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LinkRepository : CrudRepository<LinkDocument, UUID>
