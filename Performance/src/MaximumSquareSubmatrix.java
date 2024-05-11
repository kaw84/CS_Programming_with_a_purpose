public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int length = a.length;
        int[][] subMatrix = new int[length][length];
        int maxSize = 0;

        for (int i = 0; i < length; i++) {
            subMatrix[i][0] = a[i][0];
            subMatrix[0][i] = a[0][i];
            maxSize = Math.max(maxSize, subMatrix[i][0]);
            maxSize = Math.max(maxSize, subMatrix[0][i]);
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (a[i][j] == 1) {
                    subMatrix[i][j] = Math.min(Math.min(subMatrix[i - 1][j], subMatrix[i][j - 1]), subMatrix[i - 1][j - 1]) + 1;
                    maxSize = Math.max(maxSize, subMatrix[i][j]);
                }
            }
        }
        return maxSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.print(size(a));

    }
}
