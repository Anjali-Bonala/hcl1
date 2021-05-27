package com.gl.librarymanagement.servlet;


import java.io.IOException;
	//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import com.gl.librarymanagement.dao.ClassNotFoundException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.gl.librarymanagement.model.Library;
import com.gl.librarymanagemnet.service.LibraryService;

@WebServlet("/deleteLibrary")


public class DeleteBook extends HttpServlet{

public void Servlet(){
		
	}
	
private static final long serialVersionUID = 1L;

		
		public void init(ServletConfig config) {
			
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
		String title = request.getParameter("Title")	;
	       Library l = new Library();
		l.setTitle(title);
		//PrintWriter pw =  response.getWriter();
		response.setContentType("text/html");
		
		LibraryService ls = new LibraryService();
		try {
			ls.deleteLibrary(l);
			RequestDispatcher rd = request.getRequestDispatcher("displayLibrary");
			request.setAttribute("msg","deleted successfully");
			rd.forward(request, response);
			response.sendRedirect("displayLibrary");
			//pw.print("<html><body>Deleted Scuccessfully</body></html>");
		}
		catch(ClassNotFoundException e) {
			RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
			request.setAttribute("msg", "Title doesn't exists");
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


