package com.example.userjdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@PostMapping("/createtable")
	public void createTable() {
		employeeDao.createTable();
	}
	
	/*@PostMapping("/insertdata")
	public void insertData() {
		employeeDao.saveTableData();
	}*/
	
	@PostMapping("/save/{id}/{firstname}/{lastname}/{address}/{contact}/{email}/{gender}")
	public void saveEmployee(@PathVariable("id") int id, @PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname, @PathVariable("address") String address, @PathVariable("contact") String contact,
			@PathVariable("email") String email, @PathVariable("gender") String gender) {
		employeeDao.saveTableData(id, firstname, lastname, address, contact, email, gender);
	}
	
	@DeleteMapping("/deletedata")
	public void deleteDataByFirstname() {
		employeeDao.deleteTableData();
	}
	
	@GetMapping("/")
	public void getTableData() {
		employeeDao.getTableData();
	}
	
	@PostMapping("/createcustomtable/{name}")
	public void createCustomTable(@PathVariable("name") String name) {
		employeeDao.createTableWithCustomName(name);
	}
	
	@PutMapping("/update/{firstname}/{lastname}/{address}/{contact}/{email}/{gender}/{id}")
	public void updateEmployee(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname, @PathVariable("address") String address, @PathVariable("contact") String contact,
			@PathVariable("email") String email, @PathVariable("gender") String gender, @PathVariable("id") int id) {
		employeeDao.updateTableData(firstname, lastname, address, contact, email, gender, id);
	}

}
