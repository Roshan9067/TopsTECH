package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Auther;

public interface AuthorRepo extends JpaRepository<Auther, Integer> {

}
