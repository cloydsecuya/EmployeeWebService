/*
    Document   : EmployeeImpl.java
    Package	   : com.secuya.Employee.Impl;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is responsible for the Web Service Implementation from the 
    	Web Service Interface

*/

// PACKAGE
package com.secuya.Employee.Impl;



// IMPORT SECTION
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import com.secuya.employee.fx.Employee;
import com.secuya.employee.fx.EmployeeFx;


// ANNOTATIONS
@WebService (endpointInterface="com.secuya.employee.fx.EmployeeFx")
public class EmployeeImpl implements EmployeeFx{
	
	// Map
	Map <String,Employee> employees = new HashMap<String,Employee>();
	
	@Override
	public Employee getEmployeeDetails(String id) {
		if(employees.containsKey(id))
			return employees.get(id);
		return new Employee();
	}

	@Override
	public String createEmployee(Employee employee) {
                try{
		        employees.put(employee.getId(), employee);
                        return "success";
                }
                
                catch(Exception e){
                	return "failed";
                }		
	}

	@Override
	public Employee [] getAllEmployees() {
		ArrayList<Employee> emps = new  ArrayList<Employee>();
		Employee emp=null;
		
		for(Map.Entry<String, Employee> e : employees.entrySet())
		{
			emp=new Employee();
			emp.setId(e.getKey());
			emp.setName(e.getValue().getName());
			emps.add(emp);
		}
		return  (Employee []) emps.toArray(new Employee[emps.size()]);
	}

	@Override
	public String removeEmployee(Employee employee) {
		
		/* @NOTE: The line below works because it is a simple String pass of id. 
		 * 		  However, the challenge here is that we must use the Employee object 
		 * 		  And specify which employee to remove!
		 * */
//		employees.remove(employee.getId());
//		return "Record removed!";
		
		System.out.println("** Attempting to remove employee from map");
		
		try {
			employees.remove(employee.getId());
			System.out.println("Record has been removed!");
			return "Success in removing";
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return "Error in removing from map";
		} 
	} 

	@Override
	public Employee updateEmployee(String id, Employee employee) {		
		System.out.println("** Updating records");
		employees.replace(id, employee);
		return employee;
	}
}
