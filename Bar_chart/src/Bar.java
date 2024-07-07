public class Bar implements Comparable<Bar> {

    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException("Arguments cannot be null and value cannot be negative");
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    @Override
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Invalid");
        }
        if (this.value == that.value) {
            return 0;
        } else if (this.value < that.value) {
            return -1;
        } else {
            return 1;
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // Sample usage
        Bar bar1 = new Bar("Bar1", 100, "Category1");
        Bar bar2 = new Bar("Bar2", 200, "Category2");
        Bar bar3 = new Bar("Bar3", 150, "Category3");

        System.out.println(bar1.getName()); // Should print "Bar1"
        System.out.println(bar2.getValue()); // Should print 200
        System.out.println(bar3.getCategory()); // Should print "Category3"

        System.out.println(bar1.compareTo(bar2)); // Should print a negative number
        System.out.println(bar2.compareTo(bar3)); // Should print a positive number
    }
}
