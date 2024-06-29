import java.util.Scanner;
import java.util.NoSuchElementException;

public class ColorHSB {

    private final int h;
    private final int s;
    private final int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("Hue must be between 0 and 359, saturation and brightness must be between 0 and 100");
        }
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    @Override
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int dh = Math.min((this.h - that.h) * (this.h - that.h), (360 - Math.abs(this.h - that.h)) * (360 - Math.abs(this.h - that.h)));
        int ds = (this.s - that.s) * (this.s - that.s);
        int db = (this.b - that.b) * (this.b - that.b);
        return dh + ds + db;
    }

    // Sample client
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB targetColor = new ColorHSB(h, s, b);
        ColorHSB closestColor = null;

        int minDistance = Integer.MAX_VALUE;
        String closestColorName = null;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            try {
                if (lineScanner.hasNext()) {
                    String name = lineScanner.next();
                    if (lineScanner.hasNextInt()) {
                        int h2 = lineScanner.nextInt();
                        if (lineScanner.hasNextInt()) {
                            int s2 = lineScanner.nextInt();
                            if (lineScanner.hasNextInt()) {
                                int b2 = lineScanner.nextInt();

                                ColorHSB compareColor = new ColorHSB(h2, s2, b2);
                                int distance = targetColor.distanceSquaredTo(compareColor);

                                if (distance < minDistance) {
                                    minDistance = distance;
                                    closestColorName = name;
                                    closestColor = compareColor;
                                }
                            }
                        }
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Invalid input format, skipping this line.");
            } finally {
                lineScanner.close();
            }
        }
        scanner.close();

        if (closestColorName != null) {
            System.out.println(closestColorName + " " + closestColor.toString());
        } else {
            System.out.println("No valid color data found.");
        }
    }
}
