package Tries;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class ContactsDirectory{
        
        Contacts root;
        public ContactsDirectory(){
            root = new Contacts();
        }
        
        class Contacts{           

        	boolean isLeaf;
            public HashMap<Character, Contacts> contacts;

            Contacts() {
                contacts = new HashMap<>();
                isLeaf = false;
            }
        }

        void addEntry(String entry) {
            Contacts temp = root;

            for(int i = 0; i< entry.length(); i++) {

                if(!temp.contacts.containsKey(entry.charAt(i))) {

                    Contacts newContacts = new Contacts();
                    temp.contacts.put(new Character(entry.charAt(i)), newContacts);
                    temp = newContacts;

                } else {                    
                    temp = temp.contacts.get(entry.charAt(i));
                }
            }
            
            temp.isLeaf = true;
        }

        int entriesMatchingPrefix(String prefix) {

            Contacts temp = root;
            Contacts prev = root;
            
            for(int i = 0; i< prefix.length(); i++) {
            	prev = temp;
            	
                if(temp.contacts.containsKey(prefix.charAt(i))) {
                    temp = temp.contacts.get(prefix.charAt(i));

                } else {                                      
                    return 0;
                }
            }
            
            return findAllWordsCount(temp);
            
        }
        
        int findAllWordsCount(Contacts node) {
        	
        	if(node.contacts.isEmpty()) {
        		return 1;
        	}
        	
        	Set<Character> contactsPrefixes = node.contacts.keySet();
        	int numWords = node.isLeaf ? 1: 0;;
        	for(char key : contactsPrefixes) {
        	
        		numWords += findAllWordsCount(node.contacts.get(key));
        	}
        	
        	return numWords;
        	
        }
    }  

    
    public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ContactsDirectory directory = new ContactsDirectory();

        for(int a0 = 0; a0 < n; a0++){
            
            String op = in.next();
            String contact = in.next();
            
            if(op.trim().equals("add")) {               
               directory.addEntry(contact);
            }
            
            if(op.trim().equals("find")) {                
                System.out.println(directory.entriesMatchingPrefix(contact));
            }            
        }
        
    }
    
    
}
