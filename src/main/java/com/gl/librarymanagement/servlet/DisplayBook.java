package com.gl.librarymanagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.librarymanagement.model.Library;
import com.gl.librarymanagemnet.service.LibraryService;



@WebServlet("/displayLibrary")

public class DisplayBook extends HttpServlet {

	public DisplayBook() {
		
	}

	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) {
		System.out.println("servlet initialized");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		LibraryService ls = new LibraryService();
		List<Library> list = new ArrayList<Library>();
		list = ls.displayLibrary();
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		request.setAttribute("list",list);
		rd.forward(request, response);
		
	}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
			doGet(req, res);
		}
	     public void destroy() {
		System.out.println("servlet destroyed");
	}
			
}
