package com.kuzmin.mongo.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.*;

@Document
@Data
public class Blog {
    @Id
    private String id;
    private String title;
    private String body;
    private String status;
    private String createdBy;
    private Date createdDate;
    private Date publishDate;
    private List<Comment> comments;
    private String categoryId;
    private Long commentsCount = 0L;

    public void addComment(Comment comment) {
        if (comments != null) {
            comments.add(comment);
        } else {
            List<Comment> com = new ArrayList<>();
            com.add(comment);
            comments = com;
        }
    }

    public void incrementCommnetsCount() {
        commentsCount++;
    }

    public String dateToStringFormat() {
        String pattern = "MMMM dd, yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "US"));
        return simpleDateFormat.format(new Date());
    }
}
