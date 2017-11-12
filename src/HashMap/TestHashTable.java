package HashMap;

public class TestHashTable {

	public static void main(String[] args) {
		
		HashTable<String, Integer> ht = new HashTable<String, Integer>(5);
		String[] keys = new String[]{"a","b","ab","abc","abcd", "abhinay", "a", "b"};
		
		for(int i = 0; i < keys.length; i++) {
			ht.put(keys[i], i);
			System.out.println( "key " + keys[i] +  " value  " +  ht.get(keys[i]));
		}
		
		System.out.println("removed " + " " + ht.remove("a"));
		System.out.println("removed " + " " + ht.remove("ab"));

		System.out.println();
		
		for(int i = 0; i < keys.length; i++) {
			System.out.println( "key " + keys[i] +  " value  " +  ht.get(keys[i]));
		}
	}
}
