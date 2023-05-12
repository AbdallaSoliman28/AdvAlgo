package task2;
// task 7
import java.util.Arrays;

public class HeapSort {
//	The main method creates an array of integers and calls the heapSort method to sort the array using a heap sort algorithm. 
//	It then prints the sorted array to the console using the Arrays.toString method.
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 5, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
//    The heapSort method takes an array of integers as input and sorts it using a heap sort algorithm. 
//    It first creates a min heap from the input data by calling the heapify method on each non-leaf node in the tree. 
//    It then extracts elements from the heap one by one and places them at the end of the array.
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // This creates a min heap from the input data
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // This extracts o ne by one elements from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // This calls max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
//	The heapify method takes an array of integers, an integer n, and an integer i as input. 
//	It recursively transforms a subtree rooted at index i into a min heap. The method first initializes the variable smallest to be equal to i. 
//	It then compares the left and right children of node i to find the smallest value. If either child is smaller than node i, 
//	it swaps their values and recursively calls itself on the affected subtree.
    public static void heapify(int[] arr, int n, int i) {
        int smallest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
        }
    }
}

