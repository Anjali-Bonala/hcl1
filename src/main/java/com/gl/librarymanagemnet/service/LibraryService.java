package com.gl.librarymanagemnet.service;

import java.util.List;

import com.gl.librarymanagement.dao.ClassNotFoundException;
import com.gl.librarymanagement.dao.LibraryDAO;
import com.gl.librarymanagement.model.Library;



public class LibraryService {

	
	public List<Library> displayLibrary(){
		LibraryDAO eo = new LibraryDAO();
		return eo.displayLibrary();
		
	}

	 
	 public Library addLibrary(Library library) throws ClassNotFoundException{
		 LibraryDAO eo = new LibraryDAO();
		 return eo.addLibrary(library);
	}
	 
	 public Library UpdateLibrary(Library library) throws ClassNotFoundException{
		 LibraryDAO eo = new LibraryDAO();
		return eo.UpdateLibrary(library);
      }
	
	 public Library deleteLibrary(Library library) throws  ClassNotFoundException {
		 LibraryDAO eo = new LibraryDAO();
     return eo.deleteLibrary(library);
		 
	 }

}
