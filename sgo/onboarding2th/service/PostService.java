package gg.onboarding2th.service;

import gg.onboarding2th.dto.PostRequestDto;
import gg.onboarding2th.dto.PostResponseDto;
import gg.onboarding2th.entity.Post;
import gg.onboarding2th.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public ResponseEntity<PostResponseDto> createPost(PostRequestDto postDto){
        Post post = Post.createPost(postDto.getTitle(), postDto.getContent());
        postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(post.getTitle(), post.getContent());
        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    public ResponseEntity<PostResponseDto> findPost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            PostResponseDto postResponseDto = new PostResponseDto(post.getTitle(), post.getContent());
            return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<PostResponseDto> updatePost(Long postId, PostRequestDto requestDto){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            Post post = Post.updatePost(optionalPost.get(), requestDto);
            postRepository.save(post);
            PostResponseDto responseDto = new PostResponseDto(post.getTitle(), post.getContent());
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }else{
            throw new Error("ERROR : post not find");
        }
    }

    public Long deletePost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            postRepository.delete(post);
            return postId;
        }else{
            throw new Error("ERROR : post not find");
        }
    }
}
