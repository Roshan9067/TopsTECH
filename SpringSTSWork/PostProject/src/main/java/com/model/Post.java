package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private String img;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private User user;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
	private List<Comment> comments;
	
	

}
