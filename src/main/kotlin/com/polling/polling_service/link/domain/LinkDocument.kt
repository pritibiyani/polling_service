package com.polling.polling_service.link.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("LinkDocument")
@Document(collection = "links")

data class LinkDocument(@Id val id: String, val longURL: String)