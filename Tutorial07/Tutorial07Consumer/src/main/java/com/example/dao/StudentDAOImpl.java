package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.StudentDAO;
import com.example.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public StudentModel selectStudent (String npm) {
		StudentModel student = restTemplate.getForObject("http://localhost:8080/rest/student/view/" + npm, StudentModel.class);
		return student;
	}
	
	@Override
	public List<StudentModel> selectAllStudents() {
		List<StudentModel> students = restTemplate.getForObject("http://localhost:8080/rest/student/viewall", List.class);
		return students;
	}

	@Override
	public void addStudent(StudentModel student) {
		restTemplate.getForObject("http://localhost:8080/rest/student/add", StudentModel.class);
	}

	@Override
	public void deleteStudent(String npm) {
		restTemplate.getForObject("http://localhost:8080/rest/student/delete" + npm, StudentModel.class);
	}

	@Override
	public void updateStudent(StudentModel student) {
		restTemplate.getForObject("http://localhost:8080/rest/student/update" + student.getNpm(), StudentModel.class);
	}
}
