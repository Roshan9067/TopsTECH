package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Publication;

public interface PublicationRepo extends JpaRepository<Publication, Integer> {

}
