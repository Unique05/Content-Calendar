package com.unique05.content_calendar.repository;

import com.unique05.content_calendar.model.Content;
import com.unique05.content_calendar.model.Status;
import com.unique05.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //We are using this class to just keep a collection of pieces of content in memory
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){ //optionals is a way that a value may or may not contain a null value
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst(); // this gives the id of the content and see if it equals the id that was just passed in, if so go ahead and return the first(findFirst) which returns an optional
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct // this is used in a method that needs to be executed after dependency injection is done to perform initialization
    private void init(){
        Content c = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(c);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
