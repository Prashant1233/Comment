package com.comments.comments.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

//import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comments.comments.entity.Comments;
import com.comments.comments.service.CommentsService;

@RestController
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	@GetMapping("api/v2/comments")
	public List<Comments> getAll(){
		return commentsService.getAll();
	}
	
	@GetMapping("/api/v2/comments/search")
	public ResponseEntity<List<Comments>> getCommentsByQuery(
	        @RequestParam(value = "name", required = false) String name,
	        @RequestParam(value = "date", required = false) String dateString) {

	    try {
	        if (name != null) {
	            List<Comments> list = commentsService.findByUsername(name);
	            return ResponseEntity.ok(list);
	        } else if (dateString != null) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            java.sql.Date date = new java.sql.Date(dateFormat.parse(dateString).getTime());
	          
	            List<Comments> list = commentsService.findCommentsByDate(date);
	            return ResponseEntity.ok(list);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@PostMapping("/api/v2/comments/post")
	public Comments save(@RequestBody Comments comments) {

		if (comments.getText() == null || comments.getText().isEmpty()) {
			throw new IllegalArgumentException("Text field is required.");
		}

		return commentsService.save(comments);
	}
	
	@PutMapping("/api/v2/comments/put")
	public Comments updateCommentsBy(@RequestParam long id,String commentsBy) {
		return commentsService.updateCommentsBy(id,commentsBy);
	}
	
	@DeleteMapping("/api/v2/comments/delete")
	public HashMap<String,String> deleteUser(@RequestParam long id){
		return commentsService.deleteUser(id);
	}
}
