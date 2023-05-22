package com.ian.springboot.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    Page<Posts> findByTitleContainingIgnoreCase(String search, Pageable pageable);

    Page<Posts> findByAuthorContainingIgnoreCase(String search, Pageable pageable);

    Page<Posts> findByContentContainingIgnoreCase(String search, Pageable pageable);
}
