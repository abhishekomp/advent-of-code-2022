package org.abhishek.advenofcode2022.misc.comparechars;

public class CompareCharacter {

	public static void main(String[] args) {
		System.out.println((int) 'a'); // cast char to int
        System.out.println('a' == 97); // char is automatically promoted to int
        System.out.println('a' + 1); // char is automatically promoted to int
        System.out.println((char) 98); // cast int to char
        
        System.out.println('a'=='a');
	}

}
