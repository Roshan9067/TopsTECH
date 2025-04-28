package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Employee;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public int addOrUpdateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(emp);
		tx.commit();
		i = 1;
		} catch (Exception e) {
			// TODO: handle exception
			i = 0;
		}
		
		return i;
	}

	@Override
	public List<Employee> allEmployees() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.createQuery("from Employee").list();
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(s.get(Employee.class, id));
			tx.commit();
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
			i = 0;
		}
		
		
		return i;
	}

	@Override
	public Employee EmployeeById(int id) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		return s.get(Employee.class, id);
		
		
	}

}
