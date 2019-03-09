package com.ron.hr;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class DepartmentController {
	private HRDAO departmentRepository;

	public DepartmentController(HRDAO d) {
		departmentRepository = d;
	}
	@CrossOrigin
    @RequestMapping(value="/", method = RequestMethod.GET)
    public Page<Department> listDepartments(Pageable pageable) {

        //logger.info("Inside listDepartments() API");

        return departmentRepository.findAll(pageable);
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Department createDepartment(@RequestBody String trial) throws Exception {

		ObjectMapper objmapper = new ObjectMapper();

		Department deptInput = objmapper.convertValue(objmapper.readValue(trial, ObjectNode.class), Department.class);

		Department deptRec = null;

		/* check if parent department information was passed */
		if (deptInput.getParentDepartment() != null) {
			Optional<Department> parentDepartment = departmentRepository.findById(deptInput.getParentDepartment().getId());
			deptInput.setParentDepartment(parentDepartment.isPresent()? parentDepartment.get(): null);

		}

		try {

			
			deptRec = departmentRepository.save(deptInput);

			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		

		return deptRec;
	}
}