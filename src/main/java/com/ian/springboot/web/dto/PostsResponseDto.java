package com.ian.springboot.web.dto;

import com.ian.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String email;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title =entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.email = entity.getEmail();
    }
}
