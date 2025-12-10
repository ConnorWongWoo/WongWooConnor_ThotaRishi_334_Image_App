/*
  ImageApp: 
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ImageApp
{
  public static void main(String[] args)
  {

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    for (Pixel[] subPixels : recoloredPixels) {
      for (Pixel pixel : subPixels) {
        pixel.setRed(pixel.getBlue());
        pixel.setGreen(pixel.getGreen());
        pixel.setBlue(pixel.getGreen());
      }
    }
    // recoloredImg.explore();

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    for (Pixel[] subPixels : negPixels) {
      for (Pixel pixel : subPixels) {
        pixel.setRed(255-pixel.getRed());
        pixel.setGreen(255-pixel.getGreen());
        pixel.setBlue(255-pixel.getBlue());
      }
    }
    // negImg.explore();
    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();
    for (Pixel[] subPixels : grayscalePixels) {
      for (Pixel pixel : subPixels) {
        pixel.setRed(pixel.getBlue());
        pixel.setGreen(pixel.getRed());
        pixel.setBlue(pixel.getGreen());
      }
    }
    // grayscaleImg.explore();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();
    // use the original pixels as the source and upsideDownPixels as the destination
    Pixel[][] src180 = origPixels; // reuse existing origPixels
    int H = src180.length; // height (rows)
    int W = src180[0].length; // width (cols)
    // 180-degree rotation mapping: (x,y) -> (W-1-x, H-1-y)
    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        int tx = (W - 1) - x;
        int ty = (H - 1) - y;
        upsideDownPixels[ty][tx].setColor(src180[y][x].getColor());
      }
    }
    upsidedownImage.explore();
    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    /* to be implemented */
    // rotate 90 degrees clockwise using matrix mapping
    // source (x,y) -> target (y, W-1-x)
    Pixel[][] src90 = rotateImg.getPixels2D();
    Picture rot90Result = new Picture(origImg.getWidth(), origImg.getHeight());
    Pixel[][] dst90 = rot90Result.getPixels2D();
    int H90 = src90.length;
    int W90 = src90[0].length;
    for (int y = 0; y < H90; y++) {
      for (int x = 0; x < W90; x++) {
        int tx = y;
        int ty = (W90 - 1) - x;
        dst90[ty][tx].setColor(src90[y][x].getColor());
      }
    }
    rot90Result.explore();

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    /* to be implemented */
    // rotate 90 degrees counter-clockwise using matrix mapping
    // source (x,y) -> target (H-1-y, x)
    Pixel[][] srcN90 = rotateImg2.getPixels2D();
    Picture rotNeg90Result = new Picture(origImg.getWidth(), origImg.getHeight());
    Pixel[][] dstN90 = rotNeg90Result.getPixels2D();
    int Hn = srcN90.length;
    int Wn = srcN90[0].length;
    for (int y = 0; y < Hn; y++) {
      for (int x = 0; x < Wn; x++) {
        int tx = (Hn - 1) - y;
        int ty = x;
        dstN90[ty][tx].setColor(srcN90[y][x].getColor());
      }
    }
    rotNeg90Result.explore();


    // Final Image: Add a small image to a larger one

    // Create a smaller version of the original and copy it into the big one
    Picture big = new Picture(pictureFile);
    Picture small = new Picture(pictureFile).getPictureWithWidth(Math.max(1, big.getWidth() / 4));
    big.copy(small, 20, 20);
    big.explore();




    // ===== MATRIX AND VECTOR TESTS =====
    System.out.println("\n=== Vector1by2.dot() Test ===");
    Vector1by2 v1 = new Vector1by2(1, 3);
    Vector1by2 v2 = new Vector1by2(4, 2);
    double dotResult = Vector1by2.dot(v1, v2);
    System.out.println("dot([1, 3], [4, 2]) = " + dotResult + " (expected: 10.0)");

    System.out.println("\n=== Matrix2by2.multiply() Test ===");
    Matrix2by2 m1 = new Matrix2by2(1, 2, 3, 4);
    Matrix2by2 m2 = new Matrix2by2(2, 0, 1, 2);
    Matrix2by2 mResult = Matrix2by2.multiply(m1, m2);
    System.out.println("m1 = " + m1);
    System.out.println("m2 = " + m2);
    System.out.println("m1 * m2 = " + mResult);
    System.out.println("(expected: [[4.0, 4.0], [10.0, 8.0]])");

    System.out.println("\n=== Vector1by2.multiply(Vector, Matrix) Test ===");
    Vector1by2 row = new Vector1by2(1, 2);
    Matrix2by2 mat = new Matrix2by2(3, 4, 5, 6);
    Vector1by2 vResult = Vector1by2.multiply(row, mat);
    System.out.println("row = " + row);
    System.out.println("matrix = " + mat);
    System.out.println("[1, 2] * matrix = " + vResult);
    System.out.println("(expected: [13.0, 16.0])");

  }
}
