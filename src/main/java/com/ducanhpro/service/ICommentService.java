package com.ducanhpro.service;

import com.ducanhpro.model.Comment;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

public interface ICommentService{
    Iterable<Comment> findCommentByDate(Date date);
    Iterable<Comment> findAll();

    Optional<Comment> findById(Long id);

    void save(Comment t);

    void remove(Long id);
}
