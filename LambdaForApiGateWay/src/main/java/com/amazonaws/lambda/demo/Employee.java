package com.amazonaws.lambda.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Employee {
private int empid;
private String empname;
private int age;
private String email;
public Employee() {}
public Employee(String json) {
    Gson gson = new Gson();
    Employee request = gson.fromJson(json, Employee.class);
    this.empid = request.getEmpid();
    this.empname = request.getEmpname();
    this.age=request.getAge();
    this.email=request.getEmail();
}

public String toString() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
