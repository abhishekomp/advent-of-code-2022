package org.abhishek.advenofcode2022.dayseven.model;

public class File {
	
	private final int size;
	private final String fileName;

	public File(String fileName, int size) {
		this.fileName = fileName;
		this.size = size;
	}
	
	public String getFileName() {
		return fileName;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "File [size=" + size + ", fileName=" + fileName + "]";
	}

}
