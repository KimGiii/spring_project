package com.kingloo.web.service.posts;

import com.kingloo.web.domain.posts.Posts;
import com.kingloo.web.domain.posts.PostsRepository;
import com.kingloo.web.web.dto.PostsResponseDto;
import com.kingloo.web.web.dto.PostsSaveRequestDto;
import com.kingloo.web.web.dto.PostsUpdateRequestDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Posts posts = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없음 id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글 없음. Id=" + id));

        return new PostsResponseDto(entity);
    }
}
