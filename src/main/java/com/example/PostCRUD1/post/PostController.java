package com.example.PostCRUD1.post;
import com.example.PostCRUD1.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping

    public Page<Post> getAllPost(Pageable pageable){
        return postService.getAllPost(pageable);
    }

    @GetMapping("/{post_id}")
    public Post getPostById(@PathVariable(value ="post_id") Long postId ){
        return postService.getPostById(postId);
    }
    @PostMapping
    public Post createPost(@Valid @RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{post_id}")
    public Post updatePost(@PathVariable(value = "post_id") long postId ,@Valid @RequestBody Post postRequest) {
        return postService.updatePost(postId,postRequest);
    }

    @DeleteMapping("/{post_id}")
    public void deletePost(@PathVariable(value = "post_id") Long postId){
        postService.deletePost(postId);
}

}
