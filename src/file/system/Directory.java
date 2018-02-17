package file.system;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	
	/** list of entries including the directories and files in it.*/
	final List<Entry> entries;
	
	Directory(Directory parentDirectory, String name) {
		super(name, parentDirectory);
		entries = new ArrayList<>();
	}
	
	/**
	 * Add entry to the directory.
	 * not handling duplicates right now.
	 */
	boolean addEntry(Entry entry) {
		entries.add(entry);
		return true;
	}
	
	/**
	 * Deletes an entry from the directory.
	 */
	boolean deleteEntry(String name) {
		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i).getName().equals(name)) {
				entries.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/** return the number of files in the directory. */
	int getNumberOfFiles() {
		return 0;
	}
	
	/** 
	 * Returns the size of the directory recursively searching all
	 * the directories within it.*/
	int getSize() {
		int size = 0;
		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i) instanceof File) {
				File fileEntry = (File)entries.get(i);
				size += fileEntry.getSize();
			} else {
				Directory directory = (Directory) entries.get(i);
				size += directory.getSize();
			}
		}
		return size;
	}
}
