package arraysAndstrings;

public class PalindromePermutation {

	public static void main(String[] args) {
		
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.checkPalindrome("aabbbccc"));
	}
	
	/** CTCI 1.4 */
	boolean checkPalindrome(String str) {
		
		int[] a = new int[Character.valueOf('z') - Character.valueOf('a') + 1];
		
		for(int i = 0; i< str.length(); i++) {
			char t = str.charAt(i);
			if(t != ' ' && Character.valueOf(t) >= Character.valueOf('a') 
					&& Character.valueOf(t) <= Character.valueOf('z')) {
				
				a[Character.valueOf(t) - Character.valueOf('a')]++;
			}
		}
		
		int numOddValues = 0;
		for(int i =0; i<a.length; i++) {
			if(a[i] %2 == 1){
				numOddValues++;
			}
		}
		
		if(numOddValues > 1) return false;
		
		return true;
	}
}
