package org.abhishek.advenofcode2022.daytwo;

public class EnumTest {

	public static void main(String[] args) {
		
		Player player1 = new Player(PlayerMoveEnum.A);
		String name = player1.getMove().name;
		System.out.println(name);
		
		PlayerMoveEnum valueOf = PlayerMoveEnum.valueOf("K");
		System.out.println(valueOf);
		

	}

}
