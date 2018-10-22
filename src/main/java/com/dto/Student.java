package com.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;

@SQLDelete(sql="update Student set status='exited' where id=?")
@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String address;
	@ManyToOne
	@JoinColumn(name="deptId")
	private Department dept;
	
	private String status;
	
	@ElementCollection
	private List<Address> list;
	
	public Student(int id, String name, String address,Department dept) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.dept=dept;

	}
	
	public Student (Department dept) {
		this.dept=dept;
	}
	
public Student () {
		
	}
public Student (String name) {
		this.name=name;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<Address> getList() {
		return list;
	}

	public void setList(List<Address> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", dept=" + dept + ", list=" + list
				+ "]";
	}
	
	
	

}
