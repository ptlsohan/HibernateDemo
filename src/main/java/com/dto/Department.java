package com.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {

	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(List<Student> student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}
	
	
	public Department(String name, int deptId, List<Student> student) {
		super();
		this.name = name;
		this.deptId = deptId;
		this.student = student;
	}


	private String name;
	@Id
	private int deptId;
	@OneToMany(mappedBy="dept")
	private List<Student> student;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", deptId=" + deptId + "]";
	}
	
	
	

}
