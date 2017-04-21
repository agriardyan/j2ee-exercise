package servletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Bundle;
import pojo.Student;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
//@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin","guest"}))
public class Servlet extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;
	
	private int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected synchronized void increment() {
    	count++;
    }
    
    protected synchronized void decrement() {
    	count--;
    }
    
    protected synchronized int getCount() {
    	return count;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
