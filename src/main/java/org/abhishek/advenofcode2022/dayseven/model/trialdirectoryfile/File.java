package org.abhishek.advenofcode2022.dayseven.model.trialdirectoryfile;

public class File {
	
	private final int size;

	public File(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "File [size=" + size + "]";
	}
}
