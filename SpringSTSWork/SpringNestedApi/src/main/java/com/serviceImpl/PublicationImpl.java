package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Publication;
import com.repo.PublicationRepo;
import com.service.PublicationService;

@Service
public class PublicationImpl implements PublicationService {
	
	@Autowired
	PublicationRepo publicationRepo;

	@Override
	public List<Publication> allPublications() {
		// TODO Auto-generated method stub
		return publicationRepo.findAll();
	}

	@Override
	public Publication addPublication(Publication pub) {
		// TODO Auto-generated method stub
		return publicationRepo.save(pub);
	}

	@Override
	public Publication updatePublication(Publication pub, int id) {
		// TODO Auto-generated method stub
		pub.setId(id);
		return publicationRepo.save(pub);
	}

	@Override
	public void deletePublication(int id) {
		// TODO Auto-generated method stub
		publicationRepo.deleteById(id);
	}

	@Override
	public Publication publicationById(int id) {
		// TODO Auto-generated method stub
		return publicationRepo.findById(id).orElseThrow();
	}

}
