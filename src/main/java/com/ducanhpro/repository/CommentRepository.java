package com.ducanhpro.repository;

import com.ducanhpro.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query(value = "SELECT a from Comment a where a.date =:today")
    Iterable<Comment> findCommentByDate(@Param("today") LocalDate today);
    Page<Comment> findCommentByDate(LocalDate date , Pageable pageable);
}