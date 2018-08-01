package com.example.PostCRUD1.comment;

import com.example.PostCRUD1.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
    List<Comment> findAll();
}

