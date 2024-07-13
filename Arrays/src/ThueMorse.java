public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] sequence = new boolean[n];
        sequence[0] = false;

        for (int i = 1; i < n / 2; i++) {
            boolean prev = sequence[i - 1];
            if ((i + 1) % 2 == 0) {
                sequence[i] = !prev;
            }
            else {
                sequence[i] = prev;
            }
        }

        for (int i = n / 2; i < n; i++) {
            boolean prev = sequence[i - n / 2];
            sequence[i] = !prev;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i]) {
                    if (sequence[j]) {
                        System.out.print("+  ");
                    }
                    else {
                        System.out.print("-  ");
                    }
                }
                else {
                    if (sequence[j]) {
                        System.out.print("-  ");
                    }
                    else {
                        System.out.print("+  ");
                    }
                }

            }
            System.out.println();
        }
    }
}
