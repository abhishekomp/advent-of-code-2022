package org.abhishek.advenofcode2022.daytwo;

public enum PlayerMoveEnum {
	
	A("Rock", 1),
	B("Paper", 2),
	C("Scissors", 3),
	X("Rock", 1),
	Y("Paper", 2),
	Z("Scissors", 3),
	K("Kang", 3);
	
	final String name;
	final int point;
	
	private PlayerMoveEnum(String name, int point) {
		this.name = name;
		this.point = point;
	}

}
