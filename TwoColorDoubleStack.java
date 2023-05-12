package task2;
// task 3
public class TwoColorDoubleStack {
    private int n;
    private int[] red;
    private int[] blue;
    private int redTop;
    private int blueTop;
//These lines declare three private instance variables for the class: an integer array called arr, and two integers called redTop and blueTop.
    public TwoColorDoubleStack(int n) {
    	// This line sets the value of the n variable to the value of the n argument.
        this.n = n;
        this.red = new int[n / 2];
        this.blue = new int[n / 2];
        this.redTop = -1;
        this.blueTop = n / 2;
    }
    
//This is the constructor for the class. It takes an integer argument called capacity, 
//which specifies the maximum size of each stack. The constructor initializes the arr array to a new integer array with length equal to capacity,
//sets the value of redTop to -1 indicating that the red stack is empty,
//and sets the value of blueTop to capacity (indicating that the blue stack is empty).
    
    // This block of code checks if there is enough space in the red stack to push an item. If there is not enough space, it throws a runtime exception.
    public void redPush(int item) {
        if (redTop + 1 == blueTop) {
            throw new RuntimeException("Stack Overflow");
        }
        red[++redTop] = item;
        // If there is enough space in the red stack, this line pushes the item onto the red stack.
    }
    // This block of code checks if there is enough space in the blue stack to push an item. If there is not enough space, it throws a runtime exception
    public void bluePush(int item) {
        if (blueTop - 1 == redTop) {
            throw new RuntimeException("Stack Overflow");
        }
        // If there is enough space in the blue stack, this line pushes the item onto the blue stack.
        blue[--blueTop] = item;
    }

    public int redPop() {
    	// This block of code checks if there are any items on the red stack to pop. If there are no items on the red stack, it throws a runtime exception.
        if (redTop == -1) {
            throw new RuntimeException("Stack Underflow");
        }
        // If there are items on the red stack, this line pops the top item off of the red stack and returns it.
        return red[redTop--];
    }

    public int bluePop() {
        if (blueTop == n) {
        	// This block of code checks if there are any items on the blue stack to pop. If there are no items on the blue stack, it throws a runtime exception.
            throw new RuntimeException("Stack Underflow");
        }
        // If there are items on the blue stack, this line pops the top item off of the blue stack and returns it.
        return blue[blueTop++];
    }
   
//    This block of code is the main method of the program. 
//    It creates a new instance of the TwoColorDoubleStack class with a size of 10. 
//    It then pushes the integers 1 and 3 onto the red stack, and the integers 2 and 4 onto the blue stack. Finally, 
//    it pops the top item off of the red stack and prints it to the console, 
//    and then pops the top item off of the blue stack and prints it to the console.
    
    public static void main(String[] args) {
        TwoColorDoubleStack stack = new TwoColorDoubleStack(10);
        stack.redPush(1);
        stack.bluePush(2);
        stack.redPush(3);
        stack.bluePush(4);
        System.out.println(stack.redPop()); 
        System.out.println(stack.bluePop()); 
    }
}

