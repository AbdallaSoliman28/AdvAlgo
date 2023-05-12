package task1;

public class ArrayDuplicates {
	public static int removeDuplicates(String arr[], int n)
    {
		// This line checks if the length of the array is 0 or 1. If it is, then it returns the length of the array.
        if (n == 0 || n == 1)
            return n;
       //This line starts a for loop that iterates through the array from index 0 to n-2.
        int j = 0;
        // This line checks if the current element is not equal to the next element. 
        // If it is not, then it assigns the current element to the j-th position of the array and increments j by 1.
        for (int i = 0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];
       //This line assigns the last element of the array to the j-th position of the array and increments j by 1.
        arr[j++] = arr[n-1];
       
        return j;
    }
	public static void main(String args[]) {
		String []array = {"a","a","b","b","c","c","d","d"};
		int length = array.length;
		// This line calls the removeDuplicates method with the array and length as input parameters and assigns its return value to length.
		length = removeDuplicates(array, length);
		for(int i=0;i<length;i++) 
			System.out.println(array[i]);			
	}
}
