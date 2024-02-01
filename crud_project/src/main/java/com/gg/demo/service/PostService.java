package com.gg.demo.service;

import com.gg.demo.domain.PostDTO;
import com.gg.demo.entity.Post;
import com.gg.demo.jpa.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepo repo;

    @Autowired
    public PostService(PostRepo repo) {
        this.repo = repo;
    }

    public void createPost(PostDTO.createPostDto post) {
        Post newEntity = new Post(post.getTitle(), post.getContent());
        repo.save(newEntity);
    }

    public PostDTO.createPostDto getPost(Long id) {
        Optional<Post> optionalEPost = repo.findById(id);
        return optionalEPost.map(post -> new PostDTO.createPostDto(post.getTitle(), post.getContent()))
                .orElse(null);
    }

    public List<PostDTO.readPostDto> getAllPosts() {
        List<Post> postList = repo.findAll();
        List<PostDTO.readPostDto> dtoList = new ArrayList<>();

        for (Post post : postList) {
            PostDTO.readPostDto dto = new PostDTO.readPostDto(post.getId(), post.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public PostDTO.createPostDto updatePost(Long id, PostDTO.createPostDto update) {
        Optional<Post> optionalEPost = repo.findById(id);
        if (optionalEPost.isPresent()) {
            Post existingPost = optionalEPost.get();
            existingPost.setTitle(update.getTitle());
            existingPost.setContent(update.getContent());
            repo.save(existingPost);
            return new PostDTO.createPostDto(existingPost.getTitle(), existingPost.getContent());
        }
        return null; // or throw an exception
    }

    public void deletePost(Long id) {
        repo.deleteById(id);
    }
}
