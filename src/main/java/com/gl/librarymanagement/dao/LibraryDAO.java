package com.gl.librarymanagement.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gl.librarymanagement.dbconnection.DBConnection;
import com.gl.librarymanagement.model.Library;



public class LibraryDAO {
	public List<Library> displayLibrary(){
		Connection con = DBConnection.getConnection();
		List<Library> list = new ArrayList<Library>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

	try {
		
		String sql = "select title,author,price from library";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		
		while(rs.next())
		{
			String title = rs.getString(1);
			String author = rs.getString(2);
			int price = rs.getInt(3);
			Library l = new Library();
			l.setTitle(title);
			l.setAuthor(author);
			l.setPrice(price);
			
			
			list.add(l);
		}
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
			try {
				if(rs!= null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	try {
		if(pstmt!= null)
			pstmt.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;

}



public Library addLibrary(Library library) throws ClassNotFoundException{
Connection con = DBConnection.getConnection();
String sql = "insert into library values(?,?,?)";
PreparedStatement pstmt = null;

try {
	if(!searchByTitle(library.getTitle()))
	{
	System.out.println(searchByTitle(library.getTitle()));
	
	//String sql = "insert into library values(?,?,?)";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, library.getTitle());
	pstmt.setString(2, library.getAuthor());
	pstmt.setInt(3, library.getPrice());
	
	pstmt.executeUpdate();
	}

else {
	throw new ClassNotFoundException("Title  already exist");
}
}
catch (SQLException e) {
	e.printStackTrace();
}
finally {
	try {
		if(pstmt!= null)
		pstmt.close();
	}
		catch(SQLException e){
			e.printStackTrace();
			
		}
	}
return library;
}




public Library UpdateLibrary(Library library) throws ClassNotFoundException {

Connection con = DBConnection.getConnection();
String sql = "Update library set title =? where author= ?";
PreparedStatement pstmt = null;
try {
	if(searchByTitle(library.getTitle())) {
		
	pstmt = con.prepareStatement(sql);
	pstmt.setString(2, library.getAuthor());
	pstmt.setString(1, library.getTitle());
	
	pstmt.executeUpdate();
	System.out.println("excuted");
}
	else {
		throw new ClassNotFoundException("title doesn't exist");
	}

}
catch(SQLException  ex) {
	ex.printStackTrace();
}
finally {
	try {
		if(pstmt!= null)
		pstmt.close();
	}
		catch(SQLException  e){
			e.printStackTrace();
			
		}
	
}
return library;
}





public Library deleteLibrary(Library library) throws ClassNotFoundException {
Connection con = DBConnection.getConnection();
String sql = "Delete from library where title = ?";
PreparedStatement pstmt = null;
try {
	if(searchByTitle(library.getTitle())) {
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, library.getTitle());
	pstmt.executeUpdate();
}
	else {
		throw new ClassNotFoundException("title doesn't exist");
	}
}
catch(SQLException e) {
	e.printStackTrace();
}
finally {
	try {
		if(pstmt!= null)
	   pstmt.close();
	}
		catch(SQLException e){
			e.printStackTrace();
			
		}
	
}
return library;
}

public boolean searchByTitle(String title) {
Connection con = DBConnection.getConnection();

PreparedStatement pstmt = null;
ResultSet rs = null;

String sql= "select count(*) from library where title = ?";
try {
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, title);
	rs = pstmt.executeQuery();
	int count = 0;
		while(rs.next()) {
			count = rs.getInt(1);
		}

if(count == 0) {
	return false;
}else {
	return true;
}
}
catch(SQLException e) {
e.printStackTrace();
}
finally {
	try {
		if(pstmt!=null)
		pstmt.close();
	}
		catch(SQLException e){
			e.printStackTrace();
			
		}
	
}
return false;

}

}
