import java.awt.Color;

public class KernelFilter {

    // Apply a kernel filter to a picture.
    private static Picture applyKernel(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        Picture newPicture = new Picture(width, height);
        int kernelSize = kernel.length;
        int offset = kernelSize / 2;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double redSum = 0.0, greenSum = 0.0, blueSum = 0.0;

                for (int i = 0; i < kernelSize; i++) {
                    for (int j = 0; j < kernelSize; j++) {
                        int pixelX = (x - offset + i + width) % width;
                        int pixelY = (y - offset + j + height) % height;

                        Color color = picture.get(pixelX, pixelY);
                        double kernelValue = kernel[i][j];

                        redSum += color.getRed() * kernelValue;
                        greenSum += color.getGreen() * kernelValue;
                        blueSum += color.getBlue() * kernelValue;
                    }
                }

                int newRed = clamp((int) Math.round(redSum));
                int newGreen = clamp((int) Math.round(greenSum));
                int newBlue = clamp((int) Math.round(blueSum));

                newPicture.set(x, y, new Color(newRed, newGreen, newBlue));
            }
        }

        return newPicture;
    }

    // Clamp the color values to be within 0-255.
    private static int clamp(int value) {
        if (value < 0) return 0;
        if (value > 255) return 255;
        return value;
    }

    // Identity filter.
    public static Picture identity(Picture picture) {
        double[][] kernel = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        return applyKernel(picture, kernel);
    }

    // Gaussian blur filter.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                { 1/16.0, 2/16.0, 1/16.0 },
                { 2/16.0, 4/16.0, 2/16.0 },
                { 1/16.0, 2/16.0, 1/16.0 }
        };
        return applyKernel(picture, kernel);
    }

    // Sharpen filter.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
                {  0, -1,  0 },
                { -1,  5, -1 },
                {  0, -1,  0 }
        };
        return applyKernel(picture, kernel);
    }

    // Laplacian filter.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
                { -1, -1, -1 },
                { -1,  8, -1 },
                { -1, -1, -1 }
        };
        return applyKernel(picture, kernel);
    }

    // Emboss filter.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
                { -2, -1,  0 },
                { -1,  1,  1 },
                {  0,  1,  2 }
        };
        return applyKernel(picture, kernel);
    }

    // Motion blur filter.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = {
                { 1/9.0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1/9.0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1/9.0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1/9.0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1/9.0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1/9.0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1/9.0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1/9.0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1/9.0 }
        };
        return applyKernel(picture, kernel);
    }

    // Test client
    public static void main(String[] args) {
        Picture picture = new Picture("baboon.png");

        Picture identityPicture = identity(picture);
        identityPicture.save("baboon-identity.png");

        Picture gaussianPicture = gaussian(picture);
        gaussianPicture.save("baboon-gaussian.png");

        Picture sharpenPicture = sharpen(picture);
        sharpenPicture.save("baboon-sharpen.png");

        Picture laplacianPicture = laplacian(picture);
        laplacianPicture.save("baboon-laplacian.png");

        Picture embossPicture = emboss(picture);
        embossPicture.save("baboon-emboss.png");

        Picture motionBlurPicture = motionBlur(picture);
        motionBlurPicture.save("baboon-motion-blur.png");
    }
}
