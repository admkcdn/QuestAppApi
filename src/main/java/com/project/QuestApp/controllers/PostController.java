package com.project.QuestApp.controllers;


import com.project.QuestApp.entities.Post;
import com.project.QuestApp.requests.PostCreateRequest;
import com.project.QuestApp.requests.PostUpdateRequest;
import com.project.QuestApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }


    @GetMapping
    public List<Post>  getAllPosts(@RequestParam Optional<Long> userId){
        return  postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public  Post getOnePost(@PathVariable Long postId){
        return postService.getOnePost(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest newPost){
        return postService.updateOnePostById(postId, newPost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deletePostById(postId);
    }
}
