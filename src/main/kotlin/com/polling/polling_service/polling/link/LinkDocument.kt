package com.polling.polling_service.polling.link

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("LinkDocument")
@Document(collection = "links")

data class LinkDocument(@Id val id: String, val path: String)