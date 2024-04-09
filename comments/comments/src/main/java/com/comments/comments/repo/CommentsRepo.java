package com.comments.comments.repo;

import java.util.Date;
import java.util.List;

//import java.util.Date;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comments.comments.entity.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {

	List<Comments> findBycommentsBy(String commentsBy);
	
	List<Comments> findByDateofcomment(java.sql.Date date);
}