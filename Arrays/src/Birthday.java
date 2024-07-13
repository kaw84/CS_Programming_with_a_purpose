public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] people = new int[trials];

        for (int i = 0; i < trials; i++) {
            boolean[] birthdays = new boolean[n];
            int count = 0;
            while (true) {
                int birthday = (int) (Math.random() * n);
                count++;

                if (birthdays[birthday]) {
                    people[i] = count;
                    break;
                }
                birthdays[birthday] = true;
            }
        }
        int maxPeople = 0;
        for (int i : people) {
            maxPeople = Math.max(maxPeople, i);
        }
        int[] countOccurrences = new int[maxPeople + 1];
        for (int i : people) {
            countOccurrences[i]++;
        }

        int totalTrials = 0;
        for (int i = 1; i <= maxPeople; i++) {
            totalTrials += countOccurrences[i];
            double fraction = (double) totalTrials / trials;
            System.out.printf("%d %d %f\n", i, countOccurrences[i],
                    fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
