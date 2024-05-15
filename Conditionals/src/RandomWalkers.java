public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double sum = 0.0;

        for (int i = 0; i < trials; i++) {

            int x = 0;
            int y = 0;
            int counter = 0;

            while (Math.abs(x) + Math.abs(y) < r) {
                double random = Math.random();
                counter++;

                if (random < 0.25) {
                    x++;
                }
                else if (random < 0.5) {
                    x--;
                }
                else if (random < 0.75) {
                    y++;
                }
                else {
                    y--;
                }
            }
            sum += counter;
        }
        double average = sum / trials;
        System.out.println("average number of steps = " + average);
    }


}
