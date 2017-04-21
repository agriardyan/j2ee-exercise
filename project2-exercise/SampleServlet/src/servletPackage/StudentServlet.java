package servletPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Bundle;
import pojo.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
@MultipartConfig
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ObjectMapper mapper;
	
	private List<Student> studentList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        mapper = new ObjectMapper();
        studentList =  Arrays.asList(new Student(1, "John", "081535466412"), new Student(2, "Hans", "089565432789"),
				new Student(3, "Joplin", "0876589246251"));
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
		
		response.setContentType("application/json");
		
		String json = mapper.writeValueAsString(new Bundle(this.studentList, "Hello from Server"));
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
		
		request.getParameterMap().forEach((k,v) -> {
			try {
				response.getWriter().println(k + " " + v);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}); 
		
		response.setContentType("application/json");
		
		String requestName = !request.getParameter("name").trim().isEmpty() ? request.getParameter("name").trim() : "";
		
		String json = mapper.writeValueAsString(new Bundle(this.studentList.stream().filter(n -> n.getName().equalsIgnoreCase(requestName)).collect(Collectors.toList()), "Hello from Server"));
		response.getWriter().print(json);
	}

}
