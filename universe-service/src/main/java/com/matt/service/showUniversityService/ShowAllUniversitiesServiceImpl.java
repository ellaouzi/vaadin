package com.matt.service.showUniversityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.matt.model.entity.University;
import com.matt.repository.university.UniversityRepository;

@Service
public class ShowAllUniversitiesServiceImpl  implements ShowAllUniversitiesService{
	
	@Autowired
	private UniversityRepository universities;

	public List<University> getAllUniversities() {
		return universities.findAll();
	}

}
