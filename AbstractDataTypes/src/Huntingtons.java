public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        String substring = "CAG";

        int count = 0;
        int maxCount = 0;
        int subLength = substring.length();
        int i = 0;

        while (i <= dna.length() - subLength) {
            if (dna.substring(i, i + subLength).equals(substring)) {
                count++;
                i += subLength;
            } else {
                if (count > 0) {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                }
                i++;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s+", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String diagnosis;

        if (maxRepeats > -1 && maxRepeats < 10 || maxRepeats > 180) {
            diagnosis = "not human";
        } else if (maxRepeats < 36) {
            diagnosis = "normal";
        } else if (maxRepeats < 40) {
            diagnosis = "high risk";
        } else if (maxRepeats < 180) {
            diagnosis = "Huntington's";
        } else {
            diagnosis = "invalid";
        }

        return diagnosis;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String dna = StdIn.readString();
        removeWhitespace(dna);
        int repeats = maxRepeats(dna);
        System.out.println(repeats);
        System.out.println(diagnose(repeats));
    }
}
