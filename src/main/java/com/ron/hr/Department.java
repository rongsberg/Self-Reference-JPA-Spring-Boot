package com.ron.hr;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Department {

    @Id
    //@GenericGenerator(name = "sequence_department_id", strategy = "com.app.mycompany.AgileCenterServices.util.DepartmentIdGenerator")
    @GeneratedValue //(generator = "sequence_department_id")
    @Column(unique = true)
    private Long id;

    private String name;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	public Set<Department> getLinkedDepartments() {
		return linkedDepartments;
	}

	public void setLinkedDepartments(Set<Department> linkedDepartments) {
		this.linkedDepartments = linkedDepartments;
	}

	private String location;

    private String costCenter;
    
    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parentDepartment")
    private Department parentDepartment;

    
   
    @OneToMany(mappedBy="parentDepartment")
    private Set<Department> linkedDepartments = new HashSet<Department>();

    /* getters & setters */

}