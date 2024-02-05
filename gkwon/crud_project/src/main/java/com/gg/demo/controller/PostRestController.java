//package com.gg.demo.controller;
//
//import com.gg.demo.domain.PostDTO;
//import com.gg.demo.entity.Post;
//import com.gg.demo.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/posts")
//public class PostController {
//
//    private final PostService postService;
//
//    @Autowired
//    public PostController(PostService service) {
//        this.postService = service;
//    }
//
//    // 게시글 목록 조회
//    @GetMapping("/create")
//    public String getPostList(Model model) {
//        List<PostDTO.readPostDto> posts = postService.getAllPosts();
//        model.addAttribute("posts", posts);
//        return "postList"; // Thymeleaf 템플릿 이름
//    }
//
//    // 게시글 작성
//    @PostMapping("/create")
//    public String createPost(@ModelAttribute("createPostDto") PostDTO.createPostDto postdto) {
//        postService.createPost(postdto);
//        return "index";
//    }
//
//    @GetMapping("/createform")
//    public String createForm(Model model) {
//        // Create an instance of PostDTO and add it to the model
//        model.addAttribute("createPostDto", new PostDTO.createPostDto());
//        return "createform";
//    }
//
//    // 게시글 상세 조회
//    @GetMapping("/{postId}")
//    public String getPostDetail(@PathVariable(value = "postId")Long postId, Model model) {
//        Post post = postService.getPost(postId);
//        model.addAttribute("post", post);
//        return "postDetail"; // Thymeleaf 템플릿 이름
//    }
//
//    // 게시글 수정
//    @PostMapping("/{postId}/edit")
//    public String updatePost(@PathVariable Long postId, @ModelAttribute PostDTO.createPostDto updatedPost) {
//        postService.updatePost(postId, updatedPost);
//        return "redirect:/posts/{postId}";
//    }
//
//    // 게시글 삭제
//    @PostMapping("/{postId}/delete")
//    public String deletePost(@PathVariable Long postId) {
//        postService.deletePost(postId);
//        return "redirect:/posts";
//    }
//}

package com.gg.demo.controller;
import com.gg.demo.domain.PostDTO;
import com.gg.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    private final PostService postService;

    @Autowired
    public PostRestController(PostService service) {
        this.postService = service;
    }

    // Get all posts
    @GetMapping
    public List<PostDTO.readPostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // Create a post
    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO.createPostDto postdto) {
        postService.createPost(postdto);
    }

    // Get post by ID
    @GetMapping("/{postId}")
    public PostDTO.createPostDto getPostDetail(@PathVariable("postId") Long postId) {
        System.out.println(postId);
        return postService.getPost(postId);
    }

    // Update post by ID
    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Long postId, @RequestBody PostDTO.createPostDto updatedPost) {
        postService.updatePost(postId, updatedPost);
    }

    // Delete post by ID
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }
}
