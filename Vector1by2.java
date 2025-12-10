public class Vector1by2 {
    public double x, y;

    public Vector1by2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double dot(Vector1by2 a, Vector1by2 b) {
        return a.x * b.x + a.y * b.y;
    }

    public static Vector1by2 multiply(Vector1by2 row, Matrix2by2 m) {
        return new Vector1by2(
            row.x * m.m00 + row.y * m.m10,
            row.x * m.m01 + row.y * m.m11
        );
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}