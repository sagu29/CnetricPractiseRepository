package com.cnetric;

public class Sagar {
	
	String name;
	
	public String Welcome() {
		return "welcome to the organisation" ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sagar(String name) {
		super();
		this.name = name;
	}

	public Sagar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sagar [name=" + name + "]";
	}
	
	

}
