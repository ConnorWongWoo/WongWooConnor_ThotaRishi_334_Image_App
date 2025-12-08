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
    for (int i = 0; i < upsideDownPixels.length; i++) {
      for (int j = 0; j < upsideDownPixels[i].length; j++) {
        upsideDownPixels[i][j] = upsideDownPixels[j][i];
      }
    }
    upsidedownImage.explore();
    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    /* to be implemented */

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    /* to be implemented */


    // Final Image: Add a small image to a larger one

    /* to be implemented */




    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];
    

  }
}
