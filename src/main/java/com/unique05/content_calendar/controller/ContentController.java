package com.unique05.content_calendar.controller;

import com.unique05.content_calendar.model.Content;
import com.unique05.content_calendar.model.Status;
import com.unique05.content_calendar.repository.ContentCollectionRepository;
import com.unique05.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController //The controller is a class that accepts requests and return a response (CRUD)
@RequestMapping("/api/content")
public class ContentController {
    private final ContentRepository repository;

    @Autowired // is basically saying this is what I want to be injected, but if there is only one public constructor in your class, this is implicit and automatically added for you
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    //make a request and find all pieces of content in the system
    @GetMapping("") //we leave the path as empty because we already have a request mapping on the class itself
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)//return a message if created successfully
    @PostMapping("") //a response to a post request
    public void create(@Valid @RequestBody Content content){ // here @Valid says content needs to be valid
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }

}
