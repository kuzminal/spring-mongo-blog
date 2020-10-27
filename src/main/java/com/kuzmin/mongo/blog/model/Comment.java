package com.kuzmin.mongo.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Comment {
    @Id
    private String id;
    private String blogId;
    private String parentId;
    private String user;
    private String emailAddress;
    private String commentText;
}
