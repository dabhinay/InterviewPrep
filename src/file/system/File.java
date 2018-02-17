package file.system;

public class File extends Entry {
	
	String content;
	int size;
	
	File(String name, Directory parent, int size) {
		super(name, parent);
		this.size = size;
	}
	
	void addContent(String content) {
		this.content = content;
	}
	
	int getSize() {
		return size;
	}
	
	String getContent() {
		return content;
	}
}
