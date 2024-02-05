package onboarding2.be2.service;

import onboarding2.be2.dto.RequestDto;
import onboarding2.be2.dto.ResponseDto;
import onboarding2.be2.entity.Post;
import onboarding2.be2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ResponseDto createPost(RequestDto requestDto) {
        Post post = new Post();
        post.setTitle(requestDto.getTitle());
        post.setText(requestDto.getText());
        post = postRepository.save(post);
        return post.toResponseDto();
    }

    public ResponseDto findPost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            return post.toResponseDto();
        } else {
            return null;
        }
    }

    public List<Long> findAllPostIds() {
        return postRepository.findIdBy();
    }

    public ResponseDto updatePost(Long postId, RequestDto requestDto) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setTitle(requestDto.getTitle());
            post.setText(requestDto.getText());
            post = postRepository.save(post);
            return post.toResponseDto();
        } else {
            return null;
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
