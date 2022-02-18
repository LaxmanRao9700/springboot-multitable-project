package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpolyeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public EmloyeeEO addEmpolyee(EmloyeeEO emloyeeEO) {
		return employeeRepo.save(emloyeeEO);
	}

	public EmloyeeEO updateEmpolyee(EmloyeeEO emloyeeEO) {
		return employeeRepo.save(emloyeeEO);
	}
	/*
	 * public EmloyeeEO getEmployeeById(Integer id) { return
	 * employeeRepo.findById(id).get(); }
	 */

	public EmloyeeEO getEmployeeById(Integer id) {
		Optional<EmloyeeEO> result = employeeRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new EmployeeIdNotFoundException("Employee ID not exist in DB :" + id);
		}
	}

	public List<EmloyeeEO> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public void deleteEmpolyee(EmloyeeEO emloyeeEO) {
		employeeRepo.delete(emloyeeEO);
	}

}
