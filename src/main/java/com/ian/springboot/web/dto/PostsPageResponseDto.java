package com.ian.springboot.web.dto;

import com.ian.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor
public class PostsPageResponseDto {

    private Page<Posts> list;
    private Integer currentPage;
    private Integer totalPage;
    private Integer prevPage;
    private Integer nextPage;
    private Boolean hasPrevPage;
    private Boolean hasNextPage;

    public PostsPageResponseDto(Page<Posts> list) {
        this.list = list;
        this.currentPage = list.getPageable().getPageNumber() + 1;
        this.totalPage = list.getTotalPages();
        this.prevPage = list.getPageable().previousOrFirst().getPageNumber();
        this.nextPage = list.getPageable().next().getPageNumber();
        this.hasPrevPage = list.hasPrevious();
        this.hasNextPage = list.hasNext();
    }
}