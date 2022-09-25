package com.ducanhpro.repository;

import com.ducanhpro.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query(value = "from Comment where 'date' like :date")
    Iterable<Comment> findCommentByDate(@Param("date") Date date);
}