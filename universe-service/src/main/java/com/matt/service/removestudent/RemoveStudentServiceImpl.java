package com.matt.service.removestudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.model.entity.Student;
import com.matt.repository.student.StudentRepository;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	public void removeStudent(Student student) {
		studentRepository.delete(student);
		
	}

}
