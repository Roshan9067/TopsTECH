package com.service;

import java.util.List;

import com.model.Publication;

public interface PublicationService {
	
	public List<Publication> allPublications();
	public Publication addPublication(Publication pub);
	public Publication updatePublication(Publication pub, int id);
	public void deletePublication(int id);
	public Publication publicationById(int id);

}
