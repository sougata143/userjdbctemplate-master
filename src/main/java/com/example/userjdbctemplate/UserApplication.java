package com.example.userjdbctemplate;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



@SpringBootApplication
public class UserApplication extends SpringBootServletInitializer{
	
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UserApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		/*SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521/orcl.168.0.119");
		ds.setUsername("VOW_LOCAL");
		ds.setPassword("VOW_LOCAL");*/
		
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		/*jdbcTemplate.execute("create table employee (id int, firstname varchar(50), lastname varchar(50), address varchar(50), contact varchar(50), email varchar(50), gender varchar(50))");
		jdbcTemplate.execute("insert into employee (firstname, lastname, address, contact, email, gender) values ('sandip','sarkar','kolkata','8013265897','sandip@gmail.com','male')");
		jdbcTemplate.execute("insert into employee (firstname, lastname, address, contact, email, gender) values ('anupam','malakar','kolkata','8013266197','anupam@gmail.com','male')");
		jdbcTemplate.execute("insert into employee (firstname, lastname, address, contact, email, gender) values ('broto','mullick','kolkata','8013265835','broto@gmail.com','male')");*/
		
		
		//ds.destroy();
		
	}

	
}
