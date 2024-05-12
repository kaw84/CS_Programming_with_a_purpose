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
        int m = (int) k;

        int[] currentArray = new int[n];
        int[] resultArray = new int[n];

        for (int i = 0; i < n; i++) {
            currentArray[i] = i;
        }

        int currentInversions = 0;
        for (int i = n - 1; i > 0; i--) {
            if (currentInversions + i <= m) {
                resultArray[n - 1- i] = currentArray[i];
                currentInversions += i;
            } else {
                int lastPosition = m - currentInversions;
                resultArray[n - 1 - lastPosition] = currentArray[i];
                break;
            }
        }
        int number = 0;
        for (int i = 0; i < n; i++) {
            if (resultArray[i] == 0) {
                resultArray[i] = number;
                number++;
            }
        }

        return resultArray;
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
