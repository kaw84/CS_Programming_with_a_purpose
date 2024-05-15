public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int aSquared = a * a;
        int bSquared = b * b;
        int cSquared = c * c;

        int sumAB = aSquared + bSquared;
        int sumBC = bSquared + cSquared;
        int sumAC = aSquared + cSquared;

        boolean isRightTriangle = (sumAB == cSquared) || (sumBC == aSquared) || (sumAC == bSquared);

        System.out.println(isRightTriangle);
    }
}
