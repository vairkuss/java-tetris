package work.loguert.virko.tetris.abstr;

import java.util.Arrays;


public class Display {
    int[][] matrix;

    public Display(int[] wh) {
        matrix = new int[wh[1]][wh[0]];
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
