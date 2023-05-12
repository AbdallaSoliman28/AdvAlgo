package task2;
import java.util.Arrays;

public class ArrayEquals {
	public static void main(String args[]) {
		// These lines initializes integer arrays 
		  int[] a = new int[] {1, 5, 7, 9};
		  int[] b = new int[] {9, 5, 1, 7};
		  int[] c = new int[] {1, 6, 7, 5};
		// These lines sorts the elements of the array a in ascending order.
		  Arrays.sort(a);
		  Arrays.sort(b);
		  Arrays.sort(c);
		// This line compares the arrays a and c. 
		// If they are equal, then it assigns true to the boolean variable named result. 
		// Otherwise, it assigns false.  
		  boolean result = Arrays.equals(a,c);
		  System.out.println("Array are equal " + result);
	} 
}
