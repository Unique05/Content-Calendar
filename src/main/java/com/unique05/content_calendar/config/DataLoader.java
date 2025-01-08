package com.unique05.content_calendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unique05.content_calendar.model.Content;
import com.unique05.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//@Profile("production") //if we don't want this to run in the dev profile
//or
//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;//Objectmapper is something that comes from jackson. Jackson is the way we can create objects out of JSON and deserialize them

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception{
        if(repository.count() == 0){
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));
            }
        }
    }
}
