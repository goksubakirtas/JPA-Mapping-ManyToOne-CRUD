package com.example.PostCRUD1.post;

import com.example.PostCRUD1.comment.CommentService;
import com.example.PostCRUD1.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;


@Service
@Slf4j
public class PostService {

    private final PostRepositoryy postRepository;

    private final CommentService commentService;

    public PostService(PostRepositoryy postRepository, @Lazy CommentService commentService){
        this.postRepository=postRepository;
        this.commentService = commentService;
    }

    public Page<Post> getAllPost(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post getPostById(@PathVariable(value ="post_id") Long postId ){
        Optional<Post> post= postRepository.findById(postId);
        if (!post.isPresent()){
            log.info("Post with id: "+ postId+" not found");
        }
        return post.get();
    }

    public Post createPost(@Valid @RequestBody Post post){
        return postRepository.save(post);
    }

    public Post updatePost(@PathVariable(value = "post_id") long postId , @Valid @RequestBody Post postRequest){
        Post post=getPostById(postId);
        post.setName(postRequest.getName());
        return  postRepository.save(post);
    }

    public void deletePost(@PathVariable(value = "post_id") Long postId){
        postRepository.deleteById(postId);
    }


}
