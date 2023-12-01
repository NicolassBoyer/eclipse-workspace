import java.util.Scanner;

public class FrogA {

    // read two integers separated by space and output their product
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        do {

            // Reading the input
            int N = 0;
            try {
                N = scan.nextInt();
            } catch (Exception e) {
                break;
            }

            int[] H = new int[N];
            int[] S = new int[N];

            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }

            // Calling the function that solves the problem, create a new instance of frog
            FrogA F = new FrogA();
            int e = F.findPath(S, H, N - 1);

            // writing the output
            System.out.println(e);
            for (int i = 0; i < N; ++i) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(S[i]);
            }
            System.out.println();

        } while (true);
        scan.close();

    }

    public int findPath(int[] S, int[] H, int idx) {
    	// if the current index is 0, the first rock is 1, and there are no previous rocks, so no energy returned
        if (idx == 0) {
            S[0] = 1;
            return 0;
        }
        // if current index is 1, mark second rock as 1 and give the energy required to make the first jump
        if (idx == 1) {
            S[1] = 1;
            return Math.abs(H[1] - H[0]);
        }
        
        // get energy amount for both possible paths (hop 1 or 2 rocks forward) in order to compare them
        int energy1 = findPath(S, H, idx - 1) + Math.abs(H[idx] - H[idx - 1]);
        int energy2 = findPath(S, H, idx - 2) + Math.abs(H[idx] - H[idx - 2]);

        // if the closer rock requires less energy, make that jump. Otherwise, jump to the further rock.
        if (energy1 < energy2) {
            S[idx] = 1;
            return energy1;
        } else {
        	// return 1 if it is the last rock as we are obligated to jump to it.
        	if (idx == H.length - 1) {
        		S[idx] = 1;
        	} else {
        		S[idx] = 0;
        	}
            return energy2;
        }
    }
}