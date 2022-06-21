/*
    Document   : Employee.java
    Package	   : com.secuya.employee.fx;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is a class file responsible for containing attributes and properties 
    	of an Employee and Employee object.

*/

// PACKAGE
package com.secuya.employee.fx;



// IMPORT SECTION



public class Employee {
	private String id;
	private String name;
	private String employeeNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
}
