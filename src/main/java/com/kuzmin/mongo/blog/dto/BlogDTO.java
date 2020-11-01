package com.kuzmin.mongo.blog.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kuzmin.mongo.blog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class BlogDTO {
    private String id;
    private String title;
    private String body;
    private String createdBy;
    private Date publishDate;
    private String categoryName;
    private Long commentsCount = 0L;
}
