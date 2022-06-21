/*
    Document   : EmployeeFx.java
    Package	   : com.secuya.employee.fx;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is an interface responsible for defining methods which what
    	we will use in the Web Service

*/

// PACKAGE
package com.secuya.employee.fx;



// IMPORT SECTION
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



// ANNOTATIONS
@WebService
@SOAPBinding (style=Style.RPC)
public interface EmployeeFx {
	/* Getting the Employee object using the ID as a parameter */
	@WebMethod Employee getEmployeeDetails(String id);
	
	/* Creating Employees and filling the attributes through an Employee object */
	@WebMethod String createEmployee(Employee employee);
	
	/* Removing Employees from the Map */
	@WebMethod String removeEmployee(Employee employee);

	/* Update the employee record based on the requested ID */
	@WebMethod Employee updateEmployee(String id, Employee employee);
	
	/* Get all Employees in an array so we can possibly list it */
	@WebMethod Employee [] getAllEmployees();
}
