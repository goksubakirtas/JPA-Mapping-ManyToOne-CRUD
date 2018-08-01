package com.example.PostCRUD1.comment;

import com.example.PostCRUD1.model.Comment;
import com.example.PostCRUD1.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequestMapping("/post/{post_id}/comment")
@AllArgsConstructor
public class CommentController{

    private final CommentService commentService;

    @GetMapping("/comment")
    public Page<Comment> getAllComment(Pageable pageable){
        return commentService.getAllComment(pageable);
    }

    @GetMapping("comment/{comment_id}")
    public Comment getCommentsById(@PathVariable(value = "comment_id") Long commentId){
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/post/{post_id}/comment")
    public Comment createComment(Post post, @Valid @RequestBody Comment comment){
        return commentService.createComment(post,comment);
    }

    @PutMapping("/comment/{comment_id}")
    public Comment updateComment(@PathVariable(value = "comment_id") long commentId , @Valid @RequestBody Comment comment, @PathVariable(value = "comment_id") Post post) {
        return  commentService.updateComment(commentId, comment, post);

    }
    @DeleteMapping("/comment/{comment_id}")
    public void deleteComment(@PathVariable(value = "comment_id") Long commentId){
        commentService.deleteComment(commentId);
    }

}
