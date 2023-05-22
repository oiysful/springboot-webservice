package com.ian.springboot.service.posts;

import com.ian.springboot.domain.posts.Posts;
import com.ian.springboot.domain.posts.PostsRepository;
import com.ian.springboot.web.dto.PostsResponseDto;
import com.ian.springboot.web.dto.PostsSaveRequestDto;
import com.ian.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<Posts> findAllByPage(Pageable pageable) {

        return postsRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Posts> search(Pageable pageable, String select, String keyword) {

        return switch (select) {
            case "title" -> postsRepository.findByTitleContainingIgnoreCase(keyword, pageable);
            case "author" -> postsRepository.findByAuthorContainingIgnoreCase(keyword, pageable);
            default -> postsRepository.findByContentContainingIgnoreCase(keyword, pageable);
        };
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

}