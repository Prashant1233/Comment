package com.comments.comments.entity;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Comments")
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(name="commentsBy",nullable=false)
	private String commentsBy;
	@Column(name="Text",nullable=false,columnDefinition="TEXT")
	private String text;
	@Column(name="dateofcomment",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofcomment;
	
	
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comments(long id, String commentsBy, String text, Date dateofcomment) {
		super();
		Id = id;
		this.commentsBy = commentsBy;
		this.text = text;
		this.dateofcomment = dateofcomment;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getCommentsBy() {
		return commentsBy;
	}


	public void setCommentsBy(String commentsBy) {
		this.commentsBy = commentsBy;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDateofcomment() {
		return dateofcomment;
	}


	public void setDateofcomment(Date dateofcomment) {
		this.dateofcomment = dateofcomment;
	}


	@Override
	public String toString() {
		return "Comments [Id=" + Id + ", commentsBy=" + commentsBy + ", text=" + text + ", dateofcomment="
				+ dateofcomment + "]";
	}
	
	

	

}



