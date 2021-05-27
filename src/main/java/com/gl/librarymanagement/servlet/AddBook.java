package com.gl.librarymanagement.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.librarymanagement.dao.ClassNotFoundException;
import com.gl.librarymanagement.model.Library;
import com.gl.librarymanagemnet.service.LibraryService;

@WebServlet("/addLibrary")

public class AddBook extends HttpServlet{

public void Servlet(){
		
	}
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config){
		
		System.out.println("Servlet method initialized");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String title=  request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		
		
		Library l = new Library();
		l.setTitle(title);
		l.setAuthor(author);
		l.setPrice(Integer.parseInt(price));
		
		
		//PrintWriter pw =  response.getWriter();
		response.setContentType("text/html");
	
		
		LibraryService ls = new LibraryService();
		
		try {
			ls.addLibrary(l);
				RequestDispatcher rd = request.getRequestDispatcher("displayLibrary");
				request.setAttribute("msg", "Added Successfully");
				rd.include(request, response);
				response.sendRedirect("displayLibrary");
			//pw.print("<html><body>added</body1></html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
			request.setAttribute("msg", "Title already exists");
			rd.forward(request, response);
			
			e.printStackTrace();
			
			//pw.print("<html><body>"+e.getMessage()+"</body></html>");
		}
	
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doGet(req, res);
	}
public void destroy() {
	System.out.println("servlet destroyed");
}
}
