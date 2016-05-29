package reversi;
/**
 * Created by Алексей on 5/29/2016.
 */
enum CellState {
    NONE, BLACK, WHITE;
}


public class BoardConfiguration {
    public CellState [][] board;
    public CellState currentMove;
    public static CellState opposite(CellState cs) {
        CellState res = CellState.NONE;
        switch (cs) {
            case WHITE:
                res = CellState.BLACK;
                break;
            case BLACK:
                res = CellState.WHITE;
                break;
            case NONE:
                res = CellState.NONE;
        }
        return res;
    }
    public BoardConfiguration() {
        board = new CellState[8][8];
        for(int i = 0; i < 8; ++i)
            for(int j = 0; j < 8; ++j)
                board[i][j] = CellState.NONE;
        board[3][4] = CellState.BLACK;
        board[4][3] = CellState.BLACK;
        board[3][3] = board[4][4] = CellState.WHITE;
    }
    public boolean inBoard(int x, int y) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }
    public boolean isFree(int x, int y) {
        return inBoard(x, y) && (board[x][y] == CellState.NONE);
    }
}
