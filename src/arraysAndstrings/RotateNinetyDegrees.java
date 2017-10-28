package arraysAndstrings;

public class RotateNinetyDegrees {
	
	public static void main(String[] args) {
		
		int[][] a = new int[][] {
								 {1, 2, 3},
								 {4, 5, 6},
								 {7, 8, 9}
								 };
		RotateNinetyDegrees rotateNinetyDegrees = new RotateNinetyDegrees();
		rotateNinetyDegrees.rotateNinetyDegrees(a);
		
		for(int i = 0; i < a.length; i++) {		
			for(int j = 0; j < a.length; j++) {
				
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	void rotateNinetyDegrees(int[][] a) {
		
		int l = a.length;
		int i =  0;
		int j  = 0;
		
		for(int k = 0; k < l/2; k++) { // layers
			
			int nr  = l - 2*k -1; // num elements per layer / at layer k 
						
			for(int t = 0; t < nr; t++) { // elements per layer index offset 
				
				// top in temp
				int temp = a[i + k][j + k + t];
				
				// bottom top
				a[i + k][j + k + t] = a[l-1 -t -k][i+k];
				
				// right to left
				a[l-1-t -k][j+k] = a[l-1-k][l-1-t-k];
				
				// top to bottom
				a[l-1-k][l-1-t-k] = a[i+t+k][l-1-k];
				
				// left to right
				a[i+t+k][l-1-k] = temp;
			}			
		}
	
	}
	
	
}
