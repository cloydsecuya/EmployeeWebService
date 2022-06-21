/*
    Document   : ServicePublisher.java
    Package	   : com.secuya.Employee.Impl;
    Created on : June 21, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
    	This is a class that is publishing the service in the Server 
    	which delivers an XML document.

*/

// PACKAGE
package com.secuya.Employee.Impl;



// IMPORT SECTION
import javax.xml.ws.Endpoint;



public class ServicePublisher {
	/* We run this main method to deploy our server on live state so it can run */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8001/employee", new EmployeeImpl()); 
	}
}
