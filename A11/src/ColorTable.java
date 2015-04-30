import java.awt.Color;

/**
 *
 * @author Sjaak Smetsers
 * @version 1.0. 14-03-2014
 */
/**
 * Converting indexes (ranging from 0 to tableSize) to RGB colors
 *
 * @author Sjaak
 */
public class ColorTable {

    // a two dimensional conversion array 
    private int[][] rgbColors;
    private int tableSize;

    private static final int MAXRGB = 256;

    public static final int[] BLACK = new int[3];

    /**
     * converts specified color to an rgb array
     *
     * @param color the color to be converted
     * @return the corresponding array of rgb values
     */
    private static int[] color2RGB(Color color) {
        int[] rgb = {color.getRed(), color.getGreen(), color.getBlue()};
        return rgb;
    }

    /**
     * creates and fills the table with the specified size
     *
     * @param tableSize the size of the table
     */
    public ColorTable(int tableSize) {
        this.tableSize = tableSize;
        this.rgbColors = new int[tableSize][3];

        randomColorSet();
    }

    /**
     * fills the table randomly
     */
    private void randomColorSet() {
        for (int[] color : rgbColors) {
            for (int c = 0; c < 3; c++) {
                color[c] = (int) (Math.random() * 256);
            }
        }
    }

    /**
     * converts an index into an rgb value
     *
     * @param color_index to be converted
     * @return the resulting rgb value
     */
    public int[] getColor(int color_index) {
        return rgbColors[color_index % tableSize];
    }

}
