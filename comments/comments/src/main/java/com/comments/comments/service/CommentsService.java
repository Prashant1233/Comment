package com.comments.comments.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.comments.entity.Comments;
import com.comments.comments.repo.CommentsRepo;

@Service
public class CommentsService {

	@Autowired
	CommentsRepo commentsRepo;
	
	public List<Comments> getAll(){
		return commentsRepo.findAll();
	}
	
	public List<Comments>  findByUsername(String commentsBy) {
        return commentsRepo.findBycommentsBy(commentsBy);
    }
	
	 public List<Comments> findCommentsByDate(java.sql.Date date) {
	        return commentsRepo.findByDateofcomment(date);
	 }

	public Comments save(Comments comments) {
		return commentsRepo.save(comments);
	}
	
	public Comments updateCommentsBy(long id,String commentsBy){
		Optional<Comments> c=commentsRepo.findById(id);
		Comments comments=c.orElse(null);
		comments.setCommentsBy(commentsBy);
		commentsRepo.save(comments);
		return comments;
	}
	public HashMap<String,String> deleteUser(long id){
		Map<String,String> map=new HashMap<>();
		commentsRepo.deleteById(id);
		map.put("Message","deleted successfully");
		return (HashMap<String, String>) map;
	}

}
