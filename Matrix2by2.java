public class Matrix2by2 {
    public double m00, m01, m10, m11;

    public Matrix2by2(double m00, double m01, double m10, double m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    // Multiply two 2x2 matrices: C = A * B
    // c00 = a00*b00 + a01*b10,  c01 = a00*b01 + a01*b11
    // c10 = a10*b00 + a11*b10,  c11 = a10*b01 + a11*b11
    public static Matrix2by2 multiply(Matrix2by2 a, Matrix2by2 b) {
        return new Matrix2by2(
            a.m00 * b.m00 + a.m01 * b.m10,
            a.m00 * b.m01 + a.m01 * b.m11,
            a.m10 * b.m00 + a.m11 * b.m10,
            a.m10 * b.m01 + a.m11 * b.m11
        );
    }

    @Override
    public String toString() {
        return "[[" + m00 + ", " + m01 + "], [" + m10 + ", " + m11 + "]]";
    }
}
