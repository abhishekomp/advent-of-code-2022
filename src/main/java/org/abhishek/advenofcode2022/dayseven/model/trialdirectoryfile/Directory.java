package org.abhishek.advenofcode2022.dayseven.model.trialdirectoryfile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Directory {
	
	private List<File> files;
	private List<Directory> directories;
	
	public Directory() {
		this.files = new ArrayList<File>();
		this.directories = new ArrayList<Directory>();
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
	
	public Stream<File> getAllFiles() {
		//Stream<File> stream = Stream.concat(this.getFiles().stream(), Stream.of(new File(999)));
//		Stream<Object> concat = Stream.concat(this.getFiles().stream(),
//				Stream.of(this.getDirectories().stream().flatMap(d -> d.getAllFiles())));
		Stream<File> concat = Stream.concat(this.getFiles().stream(),
				this.getDirectories().stream().flatMap(d -> d.getAllFiles()));
		return concat;
	}

}
