package com.example.userjdbctemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	@Autowired
	DataSource dataSource;
	
	@Transactional
	public void createTable() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "create table employee (id int, firstname varchar(50), lastname varchar(50), address varchar(50), contact varchar(50), email varchar(50), gender varchar(50))";
		try {
			//jt.execute(sql);
			jt.execute(sql);
			System.out.println("table user2 created");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Transactional 
	public String saveTableData(int id,String firstname, String lastname, String address, String contact, String email, String gender) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "insert into employee (id, firstname, lastname, address, contact, email, gender) "
				+ "values ('"+id+"','"+firstname+"','"+lastname+"','"+address+"','"+contact+"','"+email+"','"+gender+"')";
		try {
//			jt.execute(sql);
			jt.execute(sql);
			System.out.println("data inserted successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ("data inserted "+firstname+" "+lastname+" "+address+" "+contact+" "+email+" "+gender);
	}
	
	
	@Transactional
	public void updateTableData(String firstname, String lastname, String address, String contact, String email, String gender, int id) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "update employee set firstname = ?, lastname = ?, address = ?, contact = ?, email = ?, gender = ? where id = ?";
		try {
			jt.update(sql, firstname,lastname,address,contact,email,gender,id);
			System.out.println("updated successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Transactional
	public void deleteTableData() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "delete from employee e where e.firstname = 'sandip'";
		try {
			jt.execute(sql);
			System.out.println("user deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void getTableData(){
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "select * from employee";
		List<Map<String, Object>> employees = jt.queryForList(sql);
		if(employees!=null && !employees.isEmpty()) {
			for(Map<String, Object> employee : employees) {
				for(Iterator<Map.Entry<String, Object>> it = employee.entrySet().iterator(); it.hasNext();) {
					Map.Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key+" = "+value);
				}
				System.out.println();
			}
		}
	}
	
	@Transactional
	public void createTableWithCustomName(String name) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "create table " +name+ "(id int, firstname varchar(50), lastname varchar(50), address varchar(50), "
				+ "contact varchar(50), email varchar(50), gender varchar(50))";
		try {
			//jt.execute(sql);
			jt.execute(sql);
			System.out.println("table " +name+ " created");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
