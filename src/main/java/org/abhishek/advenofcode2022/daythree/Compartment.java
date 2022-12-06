package org.abhishek.advenofcode2022.daythree;

public class Compartment {
	
	private final String content;
	
	public Compartment(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Compartment [content=" + content + "]";
	}
	
	

}
