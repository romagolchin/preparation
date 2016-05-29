package reversi;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Character.isSpaceChar;

/**
 * Created by Алексей on 5/29/2016.
 */
public class HumanPlayer implements Player {

    public void makeMove(BoardConfiguration configuration) throws MoveException {
        Scanner input = new Scanner(System.in);
        String move = input.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < move.length(); ++i) {
            if (!isSpaceChar(move.charAt(i)) && !Character.isWhitespace(move.charAt(i)))
                sb.append(move.charAt(i));
        }
        String trimmedMove = new String(sb);
        Pattern pattern = Pattern.compile("[a-h][1-8]");
        if (!pattern.matcher(trimmedMove).matches())
            throw new MoveException("invalid move format");
        int x = (int) trimmedMove.charAt(0) - (int) 'a';
        int y = (int) trimmedMove.charAt(1) - (int) '1';
        if(configuration.board[x][y] != CellState.NONE)
            throw new MoveException("cell is not free");
    }
}
