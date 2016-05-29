package reversi;

/**
 * Created by Алексей on 5/29/2016.
 */
public class GameServer {
    Player black;
    Player white;
    BoardConfiguration configuration;

    public GameServer(Player black, Player white, BoardConfiguration configuration) {
        this.black = black;
        this.white = white;
        this.configuration = configuration;
    }

    public void play() {
        int win;
        for (int i = 0; i < 64; ++i) {
            if (configuration.currentMove == CellState.BLACK) {
                if (black.hasMoves(configuration)) {
                    try {
                        black.makeMove(configuration);
                    } catch (MoveException e) {
                        e.printStackTrace();
                    }
                } else {
                    configuration.currentMove = CellState.WHITE;
                    try {
                        white.makeMove(configuration);
                    } catch (MoveException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (white.hasMoves(configuration)) {
                    try {
                        white.makeMove(configuration);
                    } catch (MoveException e) {
                        e.printStackTrace();
                    }
                } else {
                    configuration.currentMove = CellState.BLACK;
                    try {
                        black.makeMove(configuration);
                    } catch (MoveException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
