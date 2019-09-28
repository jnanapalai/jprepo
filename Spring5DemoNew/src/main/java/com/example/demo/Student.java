package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Id
	@Column(name="id")
	private int id;
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMark() {
		return mark;
	}
	@Column(name="name")
	private String name;
	@Column(name="mark")
	private int mark;
	
	

}
