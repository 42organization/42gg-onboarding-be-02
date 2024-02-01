package gg.crud.service;

import gg.crud.dto.PostDto;
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
    public String createPost(PostDto postDto) {
        Post post = new Post(postDto);
        postRepository.save(post);
        return "new post created";
    }

    // 글 전체 조회
    public List<PostDto> findAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();

        for (Post post : postList) {
            postDtoList.add(new PostDto(post));
        }

        return postDtoList;
    }

}
