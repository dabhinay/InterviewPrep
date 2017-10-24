package Tries;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author abhinay duppelly
 * Implementation of Trie data structure.  
 */
public class Trie {

	TrieNode root;
	
	Trie() {	
		root = new TrieNode();
	}
	
	/** Inner class to keep the trie node. */
	class TrieNode{
		boolean isLeaf;
		Map<Character, TrieNode> children = new HashMap<>();
		
		TrieNode() {
			this.isLeaf = false;
		}
	}
	
	/** Insert values into the trie */
	void insert(String word) {
		
		TrieNode temp = root;
		
		for(int i = 0; i < word.length(); i++) {
			
			char c = word.charAt(i);
			if(temp.children.containsKey(c)) {
				temp = temp.children.get(c);
			} else {
				
				TrieNode t = new TrieNode();
				temp.children.put(c, t);
				temp = t;
			}
			
		}
		
		temp.isLeaf = true;	
	}
	
	boolean doesPrefixExist(String str){
		
		TrieNode temp = root;
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			if(temp.children.containsKey(c)) {				
				temp = temp.children.get(c);
			} else {
				return false;
			}			
		}
		return true;
	}
	
	boolean doesWordExist(String word){
		
		TrieNode temp = root;
		for(int i = 0; i < word.length(); i++) {
			
			char c = word.charAt(i);
			if(temp.children.containsKey(c)) {				
				temp = temp.children.get(c);
			} else {
				return false;
			}			
		}
		
		return temp.isLeaf;	
	}

	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.insert("trie");
		trie.insert("trieData");
		trie.insert("trieDataStructure");

		System.out.println("contains prefix trie  = " + trie.doesPrefixExist("trie"));
		System.out.println("contains prefix tri  = " + trie.doesPrefixExist("tri"));
		System.out.println("contains prefix try  = " + trie.doesPrefixExist("try"));
		System.out.println("contains prefix trieD  = " + trie.doesPrefixExist("trieD"));
		System.out.println("contains prefix trieDo  = " + trie.doesPrefixExist("trieDo"));

	}
	
}
