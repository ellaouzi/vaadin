package com.matt.service.showallstudents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.model.entity.Student;
import com.matt.repository.student.StudentRepository;

@Service
public class ShowAllStudentsServiceImpl implements ShowAllStudentsService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		
		return studentRepository.getAllStudents();
	}

}
