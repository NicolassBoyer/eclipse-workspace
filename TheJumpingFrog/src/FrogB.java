import java.util.*;

public class FrogB
{
        // read two integers separated by space and output their product
        public static void main(String[] args)
        {

                Scanner scan = new Scanner(System.in);

                do {

                    // Reading the input
                    int N = 0;
                    try{
                        N = scan.nextInt();
                    } catch(Exception e){
                        break;
                    }

                    int[] H = new int[N];
                    int[] S = new int [N];

                    for(int i=0;i<N;++i){
                        H[i] = scan.nextInt();
                    }


                    // Calling the function that solves the problem
                    FrogB F = new FrogB();
                    int e = F.findPath(S, H);

                    // writing the output
                    System.out.println(e);
                    for(int i=0;i<N;++i){
                        if(i>0)
                            System.out.print(" ");
                        System.out.print(S[i]);
                    }
                    System.out.println();


                }while(true);
                scan.close();

    }


/*
Need to implement your solution in the findPath function as specified in the problem specifications.

In this file you are allowed to:

* change the body of the findPath function (i.e. the implementation)
* change the signature of the findPath function in any way you want
* You are allowed to minimally change the main function - only the lilne where
   the function call to findPath is done in order for the program to compile
* You can add any variable to the class of any size, but not new methods.


*/

    public int findPath(int[] S, int[] H) {
    	// get length of the heights array, which is the number of rocks
        int n = H.length;
        // create arrays for energy and the previous index of each rock on the stack
        int[] energy = new int[n];
        int[] previous = new int[n];
        
        // initialize the first elements of the arrays, previous[0] doesn't have a first element as the first rock on the
        // stack doesn't have a previous
        energy[0] = 0;
        previous[0] = -1;
        
        // use stack to keep track of the indices of rocks
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // This for loop runs in order to calculate the energy for each rock
        for (int i = 1; i < n; i++) {
            energy[i] = energy[i - 1] + Math.abs(H[i] - H[i - 1]);
            previous[i] = i - 1;
            
            // checks if jumping two rocks back costs less energy.
            if (i >= 2 && energy[i] > energy[i - 2] + Math.abs(H[i] - H[i - 2])) {
            	// current energy is equal to the energy 2 rocks ago plus the absolute value of the current height
            	// minus the height two rocks ago
                energy[i] = energy[i - 2] + Math.abs(H[i] - H[i - 2]);
                previous[i] = i - 2;
                // don't let stack size get bigger than 2
                while (stack.size() > 2) {
                    stack.pop();
                }
            }
            // push index to stack
            stack.push(i);
        }
        
        // Update the array with the optimal path
        int idx = n - 1;
        while (idx >= 0) {
            S[idx] = 1;
            idx = previous[idx];
        }
        
        // Return the last element in the array
        return energy[n - 1];
    }
}
