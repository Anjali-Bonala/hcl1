package com.gl.librarymanagement.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.librarymanagement.model.Library;
import com.gl.librarymanagemnet.service.LibraryService;
import com.gl.librarymanagement.dao.ClassNotFoundException;


@WebServlet("/UpdateLibrary")

public class UpdateBook extends HttpServlet {

	
	public UpdateBook() {
		
	}
	private static final long serialVersionUID = 1L;
	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
	
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	Library l = new Library();
	l.setTitle(title);
	l.setAuthor(author);
	//PrintWriter pw =  response.getWriter();
	
	response.setContentType("text/html");

	LibraryService ls = new LibraryService();
	try {
		ls.UpdateLibrary(l);
		RequestDispatcher rd = request.getRequestDispatcher("displayLibrary");
		request.setAttribute("msg", "updated successfully");
		rd.forward(request, response);
	//pw.print("<html><body>Updated</body1></html>");
 }
	catch(ClassNotFoundException e) {
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		rd.forward(request, response);
		e.printStackTrace();
		//pw.print("<html><body>"+e.getMessage()+"</body></html>");
	}
 }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doGet(req, res);
	}
public void destroy() {
	System.out.println("servlet destroyed");
}
}