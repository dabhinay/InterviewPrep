package file.system;

public class TestFileSystem {
		
	public static void main(String[] args) {
		TestFileSystem fileSystem = new TestFileSystem();
		fileSystem.testAddingEntries();
	}
	
	void testAddingEntries() {
		
		Directory rootDirectory = new Directory(null, "root");
		Directory subFolderOne = new Directory(rootDirectory, "subFolderOne");
		
		File fileOne = new File("file1", rootDirectory, 5);
		File fileTwo = new File("file2", rootDirectory, 5);
		File fileThree = new File("file3", rootDirectory, 5);
		
		
		File fileFour = new File("file4", subFolderOne, 5);
		File fileFive = new File("file5", subFolderOne, 5);
		File fileSix = new File("file6", subFolderOne, 5);
		
		rootDirectory.addEntry(subFolderOne);
		rootDirectory.addEntry(fileOne);rootDirectory.addEntry(fileTwo);rootDirectory.addEntry(fileThree);
		subFolderOne.addEntry(fileFour);subFolderOne.addEntry(fileFive);subFolderOne.addEntry(fileSix);
		
		System.out.println("root directory Size " + rootDirectory.getSize());
		System.out.println("sub folder directory Size " + subFolderOne.getSize());
		rootDirectory.deleteEntry("file1");
		System.out.println("root directory Size " + rootDirectory.getSize());
		rootDirectory.deleteEntry("subFolderOne");
		System.out.println("root directory Size " + rootDirectory.getSize());

	}
	
	
}
