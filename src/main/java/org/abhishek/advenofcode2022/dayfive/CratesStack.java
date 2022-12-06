package org.abhishek.advenofcode2022.dayfive;

public class CratesStack {
	
	private final int stackId;
	private char[] charArray;
	private Stack stack;
	
	public CratesStack(int stackId, char[] charArray) {
		this.stackId = stackId;
		//this.stack = new Stack(charArray.length);
		this.stack = new Stack(100);
		populateCrateStack(stack, charArray);
	}
	
	private void populateCrateStack(Stack stack, char[] charArray) {
		for(int i = 0; i < charArray.length; i++) {
			stack.push(charArray[i]);
		}
	}

	public char removeCrate() {
		return stack.pop();
	}
	
	public void addCrate(char c) {
		stack.push(c);
	}
	
	public char getTopElement() {
		return stack.peek();
	}

	public int getStackId() {
		return stackId;
	}

}
