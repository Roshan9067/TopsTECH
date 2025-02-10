package com.AssesmentJdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class SwingExample {

	private JFrame frame;
	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingExample window = new SwingExample();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingExample() {
		initialize();
		connection();
		loaddata();
	}

	Connection con = null;
	private JTable t;

	private void connection() {
		String url = "jdbc:mysql://localhost:3306/15janjava";
		String uname = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pass);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loaddata() {

		try {
			PreparedStatement pst = con.prepareStatement("select * from user");
			ResultSet rs = pst.executeQuery();

			t.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("My Swing Example");
		frame.setBounds(100, 100, 1021, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lid = new JLabel("ID");
		lid.setFont(new Font("Tahoma", Font.BOLD, 10));
		lid.setBounds(52, 49, 79, 26);
		frame.getContentPane().add(lid);

		id = new JTextField();
		id.setBounds(248, 53, 171, 19);
		frame.getContentPane().add(id);
		id.setColumns(10);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(248, 96, 171, 19);
		frame.getContentPane().add(firstname);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(248, 132, 171, 19);
		frame.getContentPane().add(lastname);

		JLabel lname = new JLabel("FIRST NAME");
		lname.setFont(new Font("Tahoma", Font.BOLD, 10));
		lname.setBounds(52, 92, 79, 26);
		frame.getContentPane().add(lname);

		JLabel llast = new JLabel("LAST NAME");
		llast.setFont(new Font("Tahoma", Font.BOLD, 10));
		llast.setBounds(52, 128, 79, 26);
		frame.getContentPane().add(llast);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String uid = id.getText().trim().toString();
				String first = firstname.getText().trim().toString();
				String last = lastname.getText().trim().toString();
				String uemail = email.getText().trim().toString();
				String umobile = mobile.getText().trim().toString();

				String query = "insert into user values(?,?,?,?,?)";

				PreparedStatement pst;
				try {
					pst = con.prepareStatement(query);
					pst.setInt(1, 0);
					pst.setString(2, first);
					pst.setString(3, last);
					pst.setString(4, uemail);
					pst.setString(5, umobile);

					int i = pst.executeUpdate();

					if (i > 0) {
						JOptionPane.showMessageDialog(frame, "Insert Data...");
						loaddata();
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		insert.setFont(new Font("Times New Roman", Font.BOLD, 10));
		insert.setBounds(52, 266, 139, 26);
		frame.getContentPane().add(insert);

		JLabel lemail = new JLabel("EMAIL");
		lemail.setFont(new Font("Tahoma", Font.BOLD, 10));
		lemail.setBounds(52, 164, 79, 26);
		frame.getContentPane().add(lemail);

		JLabel lmobile = new JLabel("MOBILE");
		lmobile.setFont(new Font("Tahoma", Font.BOLD, 10));
		lmobile.setBounds(52, 200, 79, 29);
		frame.getContentPane().add(lmobile);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(248, 168, 171, 19);
		frame.getContentPane().add(email);

		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(248, 205, 171, 19);
		frame.getContentPane().add(mobile);

		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String first = firstname.getText().trim().toString();
				
				
				

				try {
					PreparedStatement pst = con.prepareStatement("select *  from user where first_name = ?");
					pst.setString(1,first);
					ResultSet rs = pst.executeQuery();
					t.setModel(DbUtils.resultSetToTableModel(rs));

					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		search.setFont(new Font("Times New Roman", Font.BOLD, 10));
		search.setBounds(280, 268, 139, 26);
		frame.getContentPane().add(search);

		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uid = id.getText().trim().toString();
				String first = firstname.getText().trim().toString();
				String last = lastname.getText().trim().toString();
				String uemail = email.getText().trim().toString();
				String umobile = mobile.getText().trim().toString();
				
				try {
					PreparedStatement pst = con.prepareStatement("update user set first_name = ?,last_name = ?,email = ?,mobile = ? where id=?");
					pst.setString(1, first);
					pst.setString(2, last);
					pst.setString(3, uemail);
					pst.setString(4, umobile);
					pst.setString(5, uid);
					
					int i = pst.executeUpdate();
					
					if(i > 0) {
						JOptionPane.showMessageDialog(frame, "Data updated...");
						loaddata();
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		update.setFont(new Font("Times New Roman", Font.BOLD, 10));
		update.setBounds(52, 313, 139, 26);
		frame.getContentPane().add(update);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uid = id.getText().trim().toString();
				int id1 = Integer.parseInt(uid);
				
				try {
					PreparedStatement pst = con.prepareStatement("delete from user where id = ?");
					pst.setInt(1, id1);
					int i = pst.executeUpdate();
					
					if(i > 0) {
						JOptionPane.showMessageDialog(frame, "Data Deleted...");
						loaddata();
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("Times New Roman", Font.BOLD, 10));
		delete.setBounds(280, 315, 139, 26);
		frame.getContentPane().add(delete);

		t = new JTable();
		t.setBounds(473, 49, 524, 290);
		frame.getContentPane().add(t);
		
	

	}
}
