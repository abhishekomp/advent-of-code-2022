package org.abhishek.advenofcode2022.dayseven.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Directory {
	
	private final String dirName;
	private List<File> files;
	private List<Directory> directories;
	private Directory parentDir;
	
	public Directory(String dirName) {
		this.dirName = dirName;
		this.files = new ArrayList<File>();
		this.directories = new ArrayList<Directory>();
	}
	public String getDirName() {
		return dirName;
	}		
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public List<Directory> getDirectories() {
		//return Collections.unmodifiableList(directories);
		return directories;
	}
	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}
	
	public int getSize() {
		return getAllFiles().mapToInt(File::getSize).sum();
	}
	
	public Stream<File> getAllFiles() {
		//Stream<File> stream = Stream.concat(this.getFiles().stream(), Stream.of(new File(999)));
//		Stream<Object> concat = Stream.concat(this.getFiles().stream(),
//				Stream.of(this.getDirectories().stream().flatMap(d -> d.getAllFiles())));
		Stream<File> concat = Stream.concat(this.getFiles().stream(),
				this.getDirectories().stream().flatMap(d -> d.getAllFiles()));
		return concat;
	}
	@Override
	public String toString() {
		return "Directory [dirName=" + dirName + ", files=" + files + ", directories=" + directories + "]";
	}
	public Directory getParentDir() {
		return parentDir;
	}
	public void setParentDir(Directory parentDir) {
		this.parentDir = parentDir;
	}
	
}
