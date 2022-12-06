package org.abhishek.advenofcode2022.daythree;

public class ElfGroup {
	
	private final Elf elfOne;
	private final Elf elfTwo;
	private final Elf elfThree;
	
	public ElfGroup(Elf elfOne, Elf elfTwo, Elf elfThree) {
		this.elfOne = elfOne;
		this.elfTwo = elfTwo;
		this.elfThree = elfThree;
	}

	public Elf getElfOne() {
		return elfOne;
	}

	public Elf getElfTwo() {
		return elfTwo;
	}

	public Elf getElfThree() {
		return elfThree;
	}
	
	

}
