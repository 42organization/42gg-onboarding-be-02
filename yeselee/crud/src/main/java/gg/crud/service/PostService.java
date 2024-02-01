package gg.crud.service;

import gg.crud.dto.PostRequestDto;
import gg.crud.dto.PostResponseDto;
import gg.crud.entity.Post;
import gg.crud.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
public class PostService {
    private final PostRepository postRepository;

    // 글 등록
    public String createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return "new post created";
    }

    // 글 전체 조회
    public List<PostResponseDto> findAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostResponseDto> postDtoList = new ArrayList<>();

        for (Post post : postList) {
            postDtoList.add(new PostResponseDto(post));
        }

        return postDtoList;
    }

    // 특정 글 조회
    public PostResponseDto findOnePost(Long id) {
        Post post = postRepository.findById(id).get();

        return new PostResponseDto(post);
    }

    // 글 삭제
    public String deletePost(Long id) {
        postRepository.deleteById(id);

        return "post deleted";
    }

    // 글 수정
    public Long updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).get();
        post.update(postRequestDto);

        return id;
    }

}
