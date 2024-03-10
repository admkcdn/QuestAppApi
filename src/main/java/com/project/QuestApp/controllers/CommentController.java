package com.project.QuestApp.controllers;

import com.project.QuestApp.entities.Comment;
import com.project.QuestApp.requests.CommentCreateRequest;
import com.project.QuestApp.requests.CommentUpdateRequest;
import com.project.QuestApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
    return commentService.getAllCommentWithParam(userId,postId);
    }

    @PostMapping
    public Comment commentCreate(@RequestBody CommentCreateRequest request){
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateByCommentId(commentId,request);
    }

    @DeleteMapping("{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }
}
