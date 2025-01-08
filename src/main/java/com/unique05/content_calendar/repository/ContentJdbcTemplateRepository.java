//package com.unique05.content_calendar.repository;
//
//import com.unique05.content_calendar.model.Content;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class ContentJdbcTemplateRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
//        return  new Content(rs.getInt(columnLabel: "id"),
//        rs.getString(columnLabel: "title"),
//        rs.getString(columnLabel: "desc"),
//        rs.getString(columLabel: "status"),
//        rs.getString(columnLabel: "content_type"),
//        rs.getString(columnLabel: "date_created"),
//        rs.getString(columnLabel:"date_updated"),
//        rs.getString(columnLabel:"url"));
//    }
//
//    public List<Content> getAlContent(){
//        String sql = "SELECT * FROM Content";
//        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
//        return contents;
//    }
//
//    public void createContent(String title, String desc, String status, String contentTpe, String)
//}
