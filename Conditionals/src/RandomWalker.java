public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int counter = 0;

        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + counter);

    }
}
