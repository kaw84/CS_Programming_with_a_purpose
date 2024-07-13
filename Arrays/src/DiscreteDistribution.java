public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] s = new int[a.length + 1];

        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }

        s[0] = 0;
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + a[i - 1];
        }

        double[] probabilities = new double[a.length];
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = (double) a[i] / s[s.length - 1];
        }

        for (int i = 0; i < m; i++) {
            double number = Math.random();
            double cumulativeProbability = 0.0;

            for (int j = 0; j < probabilities.length; j++) {
                cumulativeProbability += probabilities[j];

                if (number <= cumulativeProbability) {
                    int selectedNumber = (int) (1 + Math.floor(number * a.length));
                    System.out.print(selectedNumber + " ");
                    break;
                }
            }
        }
    }
}
