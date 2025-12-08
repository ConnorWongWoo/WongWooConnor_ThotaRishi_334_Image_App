public class Vector1by2 {
    public int[][] rows;
    public int[][] cols;

    public Vector1by2(int[][] _rows, int[][] _cols) {
        this.rows = _rows;
        this.cols = _cols;
    }


    public static double dot(int[] r1, int[] c1) {
        double result = 0;
        for (int i = 0; i < r1.length; i++) {
            result = result + (r1[i] + c1[i]);
        }
        return result;
    }

    public static double multiply(Vector1by2 a, Matrix2by2 b) {
        return 0;
    }
}