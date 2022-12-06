package org.abhishek.advenofcode2022.dayfive;

//Implements a Stack of char data type
public class Stack {
	
	private final int capacity;
	private char[] charArray;
	private int top;
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.charArray = new char[capacity];
		this.top = -1;
	}
	
	public void push(char c) {
		if(isStackFull()) {
			throw new RuntimeException("Stack is full");
		}
		charArray[++top] = c;
	}
	
	public char pop() {
		if(isStackEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return charArray[top--];
	}
	
	public char peek() {
		if(isStackEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return charArray[top];
	}
	
	private boolean isStackEmpty() {
		return top == -1;
	}
	
	private boolean isStackFull() {
		return top == capacity - 1;
	}

}
