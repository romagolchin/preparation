package reversi;

/**
 * Created by Алексей on 5/29/2016.
 */
public interface Player {
    public int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public void makeMove(BoardConfiguration configuration) throws MoveException;

    default boolean isMoveValid(BoardConfiguration configuration, int x, int y) {
        boolean res = false;
        for (int i = 0; i < 8; ++i) {
            int dx = dirs[i][0];
            int dy = dirs[i][1];
            int j = 1;
            while (configuration.inBoard(x + dx * j, y + dy * j)
                    && configuration.board[x + dx * j][y + dy * j] == BoardConfiguration.opposite(configuration.currentMove)) {
                ++j;
            }
            res |= (j > 1 && configuration.inBoard(x + dx * j, y + dy * j)
                    && configuration.board[x + dx * j][y + dy * j] == configuration.currentMove);
        }
        return res;
    }

    default boolean hasMoves(BoardConfiguration configuration) {
        boolean res = false;
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                if (configuration.board[i][j] == CellState.NONE)
                    res |= isMoveValid(configuration, i, j);

        return res;
    }
}
