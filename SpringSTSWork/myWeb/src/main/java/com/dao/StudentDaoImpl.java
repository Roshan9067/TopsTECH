package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public int addOrUpdateStudent(Student st) {
		// TODO Auto-generated method stub
		int i = 0;
		
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();		
			s.saveOrUpdate(st);
			tx.commit();
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
			i = 0;
		}
		
		return i ;
	}

	@Override
	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.createQuery("from Student").list();
	}

	@Override
	public Student studentById(int id) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.get(Student.class, id);
	}

	@Override
	public int deleteStudent(int id) {
		int i = 0;
		// TODO Auto-generated method stub
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();	
			//s.delete(s.get(Student.class, id));
			s.delete(studentById(id));
			tx.commit();
			i=1;
		} catch (Exception e) {
			// TODO: handle exception
			i=0;
		}
		
		return i;
	}

}
