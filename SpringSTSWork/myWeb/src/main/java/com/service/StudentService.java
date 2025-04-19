package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	public int addOrUpdateStudent(Student st);
	public List<Student>  allStudents();
	public Student studentById(int id);
	public int deleteStudent(int id);

}
