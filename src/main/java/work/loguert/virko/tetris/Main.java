package work.loguert.virko.tetris;


import work.loguert.virko.tetris.matrix.Display;
// import java.util.Scanner;


class Main {

    public static void main(String[] args) {
        int[] wh = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            wh[i] = Integer.parseInt(args[i]);
        }
        Display board = new Display(wh);
    }
}
