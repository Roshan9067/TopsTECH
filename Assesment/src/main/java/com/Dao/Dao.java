package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.User;

public class Dao {
	Connection con = null;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addStudent(User u) {
		int i = 0;
		try {
			PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, 0);
			pst.setString(2, u.getFname());
			pst.setString(3, u.getLname());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getMobile());
			pst.setString(6, u.getAddress());
			pst.setString(7, u.getGender());
			pst.setString(8, u.getPassword());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
		
	}
	
	
	public int deleteUser(int id) {
		int i = 0;
		try {
			PreparedStatement pst = con.prepareStatement("delete from student where id = ?");
			pst.setInt(1, id);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	public int updateUser(User u) {
		int i = 0;
		try {
			PreparedStatement pst = con.prepareStatement("update student set fname=?,lname=?,email=?,mobile=?,address=?,gender=?,password=? where id = ?");
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getMobile());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getGender());
			pst.setString(7, u.getPassword());
			pst.setInt(8, u.getId());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
		
	}
	
	public List<User> display() {
		List<User> user = new ArrayList<User>();
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setGender(rs.getString(7));
				user.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	
	public User getUserByEmail(String email) {
		User u = new User();
		try {
			PreparedStatement pst = con.prepareStatement("select * from student where email = ?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setGender(rs.getString(7));
				u.setPassword(rs.getString(8));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	
	public User UserbyId(int id) {
User u = new User();
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setGender(rs.getString(7));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
		
	}
	
	public User UserLogin(User u) {
		User user = null;
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student where email=? and password=?");
			pst.setString(1, u.getEmail());
			pst.setString(2,u.getPassword());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setMobile(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setGender(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	
}

}
