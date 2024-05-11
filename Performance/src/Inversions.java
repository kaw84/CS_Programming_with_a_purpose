import java.util.Random;

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int counter = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i < j && a[i] > a[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutedArray = new int[n];
        for (int i = 0; i < n; i++) {
            permutedArray[i] = i;
        }
        Random rnd = new Random();
        long permutations = 0;
        while (permutations != k) {
            int i = rnd.nextInt(n-1);
            int temp = permutedArray[i];
            permutedArray[i] = permutedArray[i+1];
            permutedArray[i+1] = temp;
            permutations = count(permutedArray);
        }

        return permutedArray;
    }
    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] numbers = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
