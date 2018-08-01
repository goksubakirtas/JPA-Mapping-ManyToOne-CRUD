package com.example.PostCRUD1.comment;

import com.example.PostCRUD1.model.Comment;
import com.example.PostCRUD1.model.Post;
import com.example.PostCRUD1.post.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    Page<Comment> getAllComment(Pageable pageable){
        List<Comment> comments=commentRepository.findAll();
        return  new PageImpl(comments,pageable,comments.size());
    }

    public Comment getCommentById(@PathVariable(value ="comment_id") Long commentId ) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            log.info("Post with id: " + commentId + " not found");
        }
        return comment.get();
    }

    public Comment createComment(Post postRequest, @Valid @RequestBody Comment commentRequest){
        commentRequest.setText(commentRequest.getText());
        commentRequest.setPost(postRequest);
        return commentRepository.save(commentRequest);
    }

    public Comment updateComment(Long commentId, @Valid @RequestBody Comment commentRequest , Post postRequest) {
        Comment comment=getCommentById(commentId);
        comment.setText(commentRequest.getText());
        return commentRepository.save(comment);}

    public void deleteComment(@PathVariable(value = "comment_id") Long commentId){
        commentRepository.deleteById(commentId);
    }


}
