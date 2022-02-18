package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

@RestController
@CrossOrigin
@RequestMapping("/employee-api")
public class EmployeeController {

	@Autowired
	private EmpolyeeService empolyeeService;

	@GetMapping("/test")
	public String testData() {
		return "testing..";
	}

	@PostMapping("/add")
	// @ResponseStatus(value=HttpStatus.OK)
	public EmloyeeEO addEmpolyee(@RequestBody EmloyeeEO emloyeeEO) {
		System.out.println("Employee add method.");
		return empolyeeService.addEmpolyee(emloyeeEO);
		// return ResponseEntity.ok(emloyeeEO);
		// return new ResponseEntity<String>(emloyeeEO, HttpStatus.OK);
	}

	@GetMapping("/getEmployeeById")
	public ResponseEntity<EmloyeeEO> getEmployeeById(@RequestParam Integer id) {
		System.out.println("Employee getEmployeeById RequestParam method.");
		EmloyeeEO emloyeeEO = empolyeeService.getEmployeeById(id);
		System.out.println("Employee object:" + emloyeeEO);
		/*
		 * if (emloyeeEO==null) { throw new UserNotFoundException("Employee not found");
		 * }
		 */
		return new ResponseEntity<EmloyeeEO>(emloyeeEO, HttpStatus.OK);
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<EmloyeeEO> getEmployeeByIds(@PathVariable Integer id) {
		System.out.println("Employee getEmployeeById PathVariable method.");
		EmloyeeEO emloyeeEO = empolyeeService.getEmployeeById(id);
		return new ResponseEntity<EmloyeeEO>(emloyeeEO, HttpStatus.OK);
	}

	@PutMapping("/updateEmployeeById/{id}")
	public EmloyeeEO updateEmployee(@PathVariable Integer id, @RequestBody EmloyeeEO emloyeeEO) {
		System.out.println("Employee updateEmployee method.");
		EmloyeeEO emloyeeEODetails = empolyeeService.getEmployeeById(id);
		emloyeeEODetails.setName(emloyeeEO.getName());
		emloyeeEODetails.setCurrentAddress(emloyeeEO.getCurrentAddress());
		emloyeeEODetails.setPerminentAddress(emloyeeEO.getPerminentAddress());
		emloyeeEODetails.setMailingAddress(emloyeeEO.getMailingAddress());
		EmloyeeEO updatedEmployeeEO = empolyeeService.updateEmpolyee(emloyeeEODetails);
		// return new ResponseEntity<EmloyeeEO>(updatedEmployeeEO, HttpStatus.OK);
		return updatedEmployeeEO;
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmloyeeEO>> getAllEmployees() {
		System.out.println("Employee getAllEmployees method.");
		List<EmloyeeEO> emloyees = empolyeeService.getAllEmployees();
		return new ResponseEntity<List<EmloyeeEO>>(emloyees, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public Map<String, Boolean> deleteEmpolyee(@PathVariable Integer id) {
		System.out.println("Employee deleteEmpolyee method.");
		EmloyeeEO employeeEO = empolyeeService.getEmployeeById(id);
		empolyeeService.deleteEmpolyee(employeeEO);
		Map<String, Boolean> map = new HashMap<>();
		map.put("deleted", Boolean.TRUE);
		return map;
	}

}
