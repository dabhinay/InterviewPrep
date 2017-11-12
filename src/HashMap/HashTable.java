package HashMap;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of a hash table using linked list chaining.
 * @Author abhinay duppelly
 */
public class HashTable<K, V> {
	
	/** The maximum capacity of the hash table. */
	private int capacity; 
	private List<LinkedListNode<K, V>> values;
	private int length = 0;
	
	/** Constructor for a hash table. */
	HashTable(int capacity) {
		this.capacity = capacity;
		values = new ArrayList<>();
		setNullValues(capacity, values); // initialize to the capacity with null values
	}
	
	private void setNullValues(int capcity,List<LinkedListNode<K, V>> values) {
		for(int i = 0; i < capcity; i++) {
			values.add(null);
		}
	}
	
	/** Inner class to store the node for every entry into the hash table. */
	class LinkedListNode<K, V> {
		
		K k; // key
		V v; // value
		LinkedListNode<K, V> prev;
		LinkedListNode<K, V> next;
		
		LinkedListNode(K k, V v) {
			this.k = k;
			this.v = v;
		}
	}
	
	/**  Method to get node for a given key. */
	LinkedListNode<K, V> getNode(K key) {
		if(key == null) return null;
		
		int index = getIndexForKey(key);
		LinkedListNode<K, V> current = values.get(index);
		while(current != null) {
			if(current.k == key) {
				break;
			}
			current = current.next;
		}
		return current;
	}
	
	/** Method to get hash key for a given key. */
	int getIndexForKey(K key) {
		// important as hash code can be negative.
		return (Math.abs(key.hashCode() % capacity)); 
	}
	
	
	/** Method to put a value into the hash table. */ 
	public V put(K k, V v) {
		int index = getIndexForKey(k);
		
		/** if it is a first entry*/
		if(values.get(index) == null) {
			LinkedListNode<K, V> entry = new LinkedListNode<K, V>(k, v);
			values.set(index, entry);
			entry.prev = null;
			entry.next = null;
			return entry.v;
			
		} else {
			/** if we are just updating an existing value. */
			LinkedListNode<K, V> node = getNode(k);
			if(node != null) {
				V oldValue = node.v;
				node.v = v;
				return oldValue;
			} else {
				/** if we are chaining the linked list. */
				LinkedListNode<K, V> entry = new LinkedListNode<K, V>(k, v);
				LinkedListNode<K, V> entryAtIndex = values.get(index);
				values.set(index, entry);
				entry.next = entryAtIndex;
				entry.prev = null;
				entryAtIndex.prev = entry;
				return  entry.v;
			}
		}
	}
	
	
	/** Method to get a value for a given key in a hash table. */
	V get(K k) {
		
		LinkedListNode<K, V> node = getNode(k);
		if(node != null) {
			return node.v;
		}
		return null;
	}
	
	
	/** Method to remove a value from a hash table. */
	public V remove(K k) {
		
		LinkedListNode<K,V> node = getNode(k);
		if(node == null) {
			return null;
		} else {
			if(node.prev != null) {
				node.prev.next = node.next;
				if(node.next != null ) node.next.prev = node.prev;
			} else {
				LinkedListNode<K, V> firstNode =  node.next;
				if(firstNode != null) firstNode.prev = null;
				values.set(getIndexForKey(k), firstNode);				
			}
		}		
		return node.v;
	}
}
