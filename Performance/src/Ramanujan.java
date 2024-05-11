public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n <= 0) {
            return false;
        }
        int counter = 0;
        int maxNumber = (int) Math.floor(Math.cbrt(n));
        long[] cubedNumbers = new long[maxNumber];
        for (int i = 0; i < maxNumber; i++) {
            for (int j = maxNumber - 1; j > maxNumber/2; j--) {
                if (cubedNumbers[j] == 0) {
                    cubedNumbers[j] = j*j*j;
                }
                if (i * i * i + cubedNumbers[j] == n) {
                    counter++;
                }
                if (cubedNumbers[i] + cubedNumbers[j] < n) {
                    break;
                }
            }
        }
        return (counter > 1);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.print(isRamanujan(n));
    }
}
