package com.example.hackaton16.domain.subject.presentation

import com.example.hackaton16.domain.subject.presentation.dto.response.QuerySubjectListResponse
import com.example.hackaton16.domain.subject.service.QuerySubjectListService
import com.example.hackaton16.domain.subject.service.SaveSubjectService
import com.example.hackaton16.global.document.subject.SubjectApiDocument
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/subject")
class SubjectController(
    private val saveSubjectService: SaveSubjectService,
    private val querySubjectListService: QuerySubjectListService
) : SubjectApiDocument {
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    override fun saveSubject(@RequestPart("image") file: MultipartFile) {
        saveSubjectService.execute(file)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun querySubjectList(): QuerySubjectListResponse {
        return querySubjectListService.execute()
    }
}