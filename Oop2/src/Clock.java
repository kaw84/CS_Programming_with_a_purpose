public class Clock {

    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Hour must be between 0 and 23, and minute must be between 0 and 59");
        }
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s == null || !s.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time must be in the format HH:MM");
        }
        String[] parts = s.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Hour must be between 0 and 23, and minute must be between 0 and 59");
        }
        this.h = h;
        this.m = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    @Override
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.h < that.h) {
            return true;
        } else if (this.h == that.h) {
            return this.m < that.m;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.m++;
        if (this.m >= 60) {
            this.m = 0;
            this.h++;
            if (this.h >= 24) {
                this.h = 0;
            }
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta must be non-negative");
        }
        int totalMinutes = this.h * 60 + this.m + delta;
        this.h = (totalMinutes / 60) % 24;
        this.m = totalMinutes % 60;
    }

    // Test client
    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59);
        System.out.println(clock1);  // Should print "23:59"

        clock1.tic();
        System.out.println(clock1);  // Should print "00:00"

        Clock clock2 = new Clock("12:30");
        System.out.println(clock2);  // Should print "12:30"

        clock2.toc(90);
        System.out.println(clock2);  // Should print "14:00"

        System.out.println(clock1.isEarlierThan(clock2));  // Should print true
    }
}
