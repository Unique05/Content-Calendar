package com.unique05.content_calendar.repository;

import com.unique05.content_calendar.model.Content;
import com.unique05.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    //query derivation i.e of the method name itself
    List<Content> findAllByTitleContains(String keyword);

    //manually defined query
    @Query("""
            SELECT * FROM Content
            where status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
