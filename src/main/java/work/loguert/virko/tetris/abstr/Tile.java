package work.loguert.virko.tetris.abstr;

import java.util.List;
import java.util.ArrayList;


public class Tile {

    short x, y;

    public short[] getCords() {
        short[] cords = { x, y };
        return cords;
    }

    public Tile(short[] cords) {
        x = cords[0];
        y = cords[1];
    }

    public static Tile nextTo(Tile parent, short[][] unallowed) {
        short[][] surroundingCords = parent.getSurrounding(unallowed);
        short randomIndex = (short) Math.round(Math.random() * surroundingCords.length);
        return new Tile(surroundingCords[randomIndex]);
    }

    public short[][] getSurrounding(short[][] unallowed) {
        List<short[]> surrounding = new ArrayList<short[]>(1);
        short[][] tiles = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (short[] tile : tiles) {
            boolean allowed = true;
            for (short[] unallowedTile : unallowed) {
                if (tile.equals(unallowedTile)) {
                    allowed = false;
                }
            }
            if (allowed) {
                surrounding.add(tile);
            }
        }
        return (short[][]) surrounding.toArray();
    }
}
