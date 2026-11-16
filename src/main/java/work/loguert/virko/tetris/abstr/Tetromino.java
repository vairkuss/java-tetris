package work.loguert.virko.tetris.abstr;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import work.loguert.virko.tetris.abstr.Tile;


public class Tetromino {
    
    Set<Tile> body;

    public Tetromino(short x) {
        for (Tile tile : body) {
            System.out.println(tile.getCords().toString());
        }
        List<Tile> indexedBody = new ArrayList<Tile>(4);
        indexedBody.add(new Tile(new short[2]));
        for (int i = 1; i < 4; i++) {
            Tile previousTile = indexedBody.get(i - 1);
            short[][] occupiedCords = indexedBody.toArray(short[][]::new);
            indexedBody.add(Tile.nextTo(previousTile, occupiedCords));
        }
        short minY = 0;
        for (Tile tile : indexedBody) {
            if (minY > tile.getCords()[0]) {
                minY = tile.getCords()[0];
            }
        }
        for (Tile tile : indexedBody) {
            tile.y -= minY;
        }
        body = new HashSet<Tile>(indexedBody);
    }

    public int[][] getSurrounding() {
        List<short[]> surrounding = new ArrayList<short[]>();
        for (Tile tile : body) {
            short[][] unallowed = (short[][]) surrounding.toArray();
            for (short[] tileSurrounding : tile.getSurrounding(unallowed))
            surrounding.add(tileSurrounding);
        }
        return (int[][]) surrounding.toArray();
    }
}
