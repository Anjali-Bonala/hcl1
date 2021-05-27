package com.gl.librarymanagement.dao;

public class ClassNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public ClassNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
public String getMessage() {
	return msg;
}

}


