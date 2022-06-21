/*
    Document   : Client.java
    Package	   : com.secuya.client;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is the Client class which will be making requests to the Web Service.
*/



// PACKAGE
package com.secuya.client;



// IMPORT SECTION
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.secuya.employee.fx.Employee;
import com.secuya.employee.fx.EmployeeFx;
import java.util.Scanner;

public class Client {
	static Scanner sc = new Scanner(System.in);
	static String opt;
	
	public static void main(String[] args) throws MalformedURLException {
		// Employee object and its relation with other attributes
		Employee request = null;
		Employee exist = new Employee();
		String emp_id; 
		String emp_name; 
		String emp_no;
		
		// Asking for the ID
		String scan_id;			// as a token
		
		// Set up the URL path
		URL url = new URL("http://localhost:8001/employee?wsdl");
				
		// Set the web service coming from the web server
		QName qname = new QName("http://Impl.Employee.secuya.com/", "EmployeeImplService");
		
		// Now, assign the web service along with the URL path
		Service service = Service.create(url, qname); 
				
		// Access the web interface
		EmployeeFx employee = service.getPort(EmployeeFx.class);
		
		// For the list and access all the Employees
		Employee[] maplist;
		
		/** UNIT TESTS ON THE CLIENT SIDE 
		 * @NOTE: This should work properly as long as server is up and running while listening
		 * */		
		// TRY MAKING CLIENT REQUESTS
		// Request 1
		exist.setId("0");
		exist.setName("[***ADMIN***] CLOYD VAN S. SECUYA");
		exist.setEmployeeNumber("272002");
		// Then, EmployeeFx.createEmployee(Employee employee)   ;; Pass the object from request
		employee.createEmployee(exist);
		
		
		// Request 2
		exist = new Employee();		// create another instance
		exist.setId("007");
		exist.setName("[***ADMIN***] JAMES BOND");
		exist.setEmployeeNumber("00700");
		// Then, EmployeeFx.createEmployee(Employee employee)   ;; Pass the object from request
		employee.createEmployee(exist);
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/** USER INPUT
		 * @NOTE: Allow user to create their own request. 
		 * 		  Use the request object
		 * */
		while(true) {
			System.out.println("Client Application ");
			System.out.println("==============================================");
			System.out.println("Create Employee       [a]");
			System.out.println("Update Employee       [b]");
			System.out.println("Remove Employee       [c]");
			System.out.println("Display Records       [d]");
			System.out.println("==============================================");
			System.out.println("\n\nExit                  [x]");
			System.out.print("Input: ");
			opt = sc.nextLine(); 
			
			System.out.println("\n\n\n\n");
			
			switch (opt) {
				case "a":
					System.out.println("Creating employee");
					
					// Create a new instance of the Employee
					request = new Employee();
					
					// Ask the user to set an ID
					System.out.print("Set an Employee ID: ");
					emp_id = sc.nextLine();
					
					// Ask the user to set Employee name
					System.out.print("Employee Name: ");
					emp_name = sc.nextLine();
					
					// And finally, ask the user to set an Employee number
					System.out.print("Set an Employee No.: ");
					emp_no = sc.nextLine();
					
					// Request methods to set all the known attributes of the Employee Class
					request.setId(emp_id);
					request.setName(emp_name);
					request.setEmployeeNumber(emp_no);
					
					// Lastly, create a new Employee and store it in a map 
					// using createEmployee()
					employee.createEmployee(request);
					
					
					break;
					
				case "b":
					
//					request = new Employee();
					
					// Preempt the id 
					scan_id = ""; 
					String newName;
					
					System.out.println("Updating employee");		
					System.out.print("Enter ID: ");
					scan_id = sc.nextLine();
					
					System.out.print("Update Name: ");
					newName = sc.nextLine();
					
						request.setName(newName);
					
					// Try updating employees
					employee.updateEmployee(scan_id, request);
					
					
					System.out.println("Employee Record Updated!!");
//					System.out.println("New Name: " + employee.getEmployeeDetails(request.getId()).getName());
					
					
					break;
				
				case "c":			
					// We need to create a new instance because it as we pass this, another object is needed!
					Employee request_and_remove = new Employee();
					
					// Preempt the token
					scan_id = "";
					
					System.out.println("Remove Employee");
					System.out.print("Enter ID: ");
					scan_id = sc.nextLine(); 
					
					request_and_remove.setId(scan_id);
					request_and_remove.setName(employee.getEmployeeDetails(scan_id).getName());
					request_and_remove.setEmployeeNumber(employee.getEmployeeDetails(scan_id).getEmployeeNumber());
					
					// Try removing some Employees
					employee.removeEmployee(request_and_remove); 
					
					
					break;
					
				case "d":
					// Fetch all the returned Employees in an array
					// Then put it inside to our declared array object
					maplist = employee.getAllEmployees();
					
					System.out.println("Display Records");
					// Try getting an output from the service which should return from the Web Interface via Server
					// This should attribute to the Employee and return properly
					System.out.print("Enter ID: ");
					String getId = sc.nextLine(); 
					System.out.println("\tQUERY STATUS:");
					System.out.println("\t=================================================================================");
					System.out.println("\tName: " + employee.getEmployeeDetails(getId).getName());
					System.out.println("\tEmployee ID: " + employee.getEmployeeDetails(getId).getId());
					System.out.println("\tEmployee No.: " + employee.getEmployeeDetails(getId).getEmployeeNumber());
					System.out.println("\t=================================================================================");
					// List all employees from a list
					System.out.println("\n\n\tList of all Employees FROM HASHMAP:");
					for (int i = 0; i < maplist.length; i++) {
						System.out.println("\t(ID: " + maplist[i].getId() + ")" + " " + maplist[i].getName());
					}
					

					break;
				
				case "x":
					System.exit(1);
					break;
				
				default:
					System.out.println("Please choose among the choices only!"); 
					break;
			}
			
			System.out.println("\n\n\n\n");
			
		} // END OF WHILE LOOP
				
		/**
		 * For the Unit test of my name
		 * This is the key: 0
		 * */
	}
}
