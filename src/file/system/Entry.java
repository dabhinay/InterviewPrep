package file.system;

import java.util.Date;

/**
 *  Abstract class for the file system that abstracts each entry 
 *  in the file system.
 */
public abstract class Entry {
	
	protected Date creationDate;
	protected Date lastModifiedDate;
	protected String entryName;
	protected Directory parentDirectory;
	
	Entry(String name, Directory parent) {
		
		this.entryName = name;
		this.parentDirectory = parent;
	}
	
	String getName() {
		return entryName;
	}
	
	Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	void modifyName() {
		this.entryName = entryName;
	}
	
	/** get the full path to the entry. */
}
