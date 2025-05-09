package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String comment;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private User user;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private Post post;

}
