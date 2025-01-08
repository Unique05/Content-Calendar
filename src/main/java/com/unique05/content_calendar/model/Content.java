package com.unique05.content_calendar.model;

/* Note:
A DTO is a class whose purpose is to transfer data, usually from the server to the client or vice versa
An entity is a class whose purpose is to store and retrieve data from a data store
A pojo is a class that doesn't extend any of the framework code and doesn't have any restrictions baked into it
*/

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("content")
public record Content(//when you define a record, you don't define properties but components of the record
        @Id
        Integer id,
        @NotBlank //validates that title must not be null
        String title,
        @Column(value = "description")
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
