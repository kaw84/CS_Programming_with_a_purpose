import java.util.Arrays;

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];

        for (int[] row : grid) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < k; i++) {
            int a, b;
            boolean positionSet = false;

            while (!positionSet) {
                a = (int) (Math.random() * m);
                b = (int) (Math.random() * n);

                if (grid[a][b] == 0) {
                    grid[a][b] = -1;
                    positionSet = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    if (i > 0 && grid[i - 1][j] != -1) {
                        grid[i - 1][j] += 1;
                    }
                    if (j > 0 && grid[i][j - 1] != -1) {
                        grid[i][j - 1] += 1;
                    }
                    if (i < m - 1 && grid[i + 1][j] != -1) {
                        grid[i + 1][j] += 1;
                    }
                    if (j < n - 1 && grid[i][j + 1] != -1) {
                        grid[i][j + 1] += 1;
                    }

                    if (i > 0 && j > 0 && grid[i - 1][j - 1] != -1) {
                        grid[i - 1][j - 1] += 1;
                    }
                    if (i > 0 && j < n - 1 && grid[i - 1][j + 1] != -1) {
                        grid[i - 1][j + 1] += 1;
                    }
                    if (i < m - 1 && j > 0 && grid[i + 1][j - 1] != -1) {
                        grid[i + 1][j - 1] += 1;
                    }
                    if (i < m - 1 && j < n - 1 && grid[i + 1][j + 1] != -1) {
                        grid[i + 1][j + 1] += 1;
                    }
                }
            }
        }
        for (int[] row : grid) {
            for (int element : row) {
                if (element == -1) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print(element + "  ");
                }
            }
            System.out.println();
        }
    }
}
