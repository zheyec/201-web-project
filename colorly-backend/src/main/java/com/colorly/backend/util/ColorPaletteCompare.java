package com.colorly.backend.util;

import java.util.ArrayList;
import java.awt.Color;

public class ColorPaletteCompare {
    private static double maxColorDistance = 50.00;

    private static double getColorDifference(Color color1, Color color2) {
        double sum = Math.pow(color1.getRed() - color2.getRed(), 2) + Math.pow(color1.getGreen() - color2.getGreen(), 2)
                + Math.pow(color1.getBlue() - color2.getBlue(), 2);
        return Math.sqrt(sum);
    }

    /*
     * Inspired by:
     * Yang, J, Chen, Y, Westland, S, Xiao, K. Predicting visual similarity between
     * colour palettes. Color Res Appl. 2020; 45: 401– 408.
     * https://doi.org/10.1002/col.22492
     */
    public static boolean areClose(ArrayList<Color> inputColors, ArrayList<Color> itemColors) {
        for (Color itemColor : itemColors) {
            double minDistance = Double.POSITIVE_INFINITY;
            for (Color inputColor : inputColors) {
                double distance = getColorDifference(inputColor, itemColor);
                minDistance = Math.min(minDistance, distance);
            }
            if (minDistance <= maxColorDistance) {
                return true;
            }
        }
        return false;
    }
}
