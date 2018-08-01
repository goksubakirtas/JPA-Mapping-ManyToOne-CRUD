package com.example.PostCRUD1.post;

import com.example.PostCRUD1.model.Comment;
import com.example.PostCRUD1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryy extends JpaRepository<Post,Long> {

}
