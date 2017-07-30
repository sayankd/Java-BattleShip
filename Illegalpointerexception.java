package com;

public class Illegalpointerexception extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s;

	public Illegalpointerexception(String string) {
		// TODO Auto-generated constructor stub
		this.s = string;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return s;
	}
	
	

}
