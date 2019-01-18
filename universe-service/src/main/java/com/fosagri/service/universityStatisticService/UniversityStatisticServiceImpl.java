package com.matt.service.universityStatisticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.repository.university.UniversityRepository;

@Service
public class UniversityStatisticServiceImpl implements UniversityStatisticService{

	@Autowired
	private UniversityRepository universityRepository;
	public Integer getNumOfStudentsForUniversity(Integer universityId) {	
		return universityRepository.getNumOfStudentForUniversities(universityId);
	}

}
