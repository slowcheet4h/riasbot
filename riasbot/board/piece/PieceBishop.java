package riasbot.board.piece;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;

import java.util.ArrayList;

public class PieceBishop extends Piece {


    public PieceBishop(Team _team, Point _location, Board _board) {
        super('B', _team, _location, _board);
    }

    @Override
    public ArrayList<Move> validMoves() {
        ArrayList<Move> moves = new ArrayList<>();

        // left down
        int y = location.y() - 1;
        for (int x = location.x() - 1; x > 0; x--) {
            Point to = new Point(x, y);
            if (!board.isLegalMove(this, to))
                break;
            moves.add(new Move(location, to));
            y--;
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

        // left up
        y = location.y() + 1;
        for (int x = location.x() - 1; x > 0; x--) {
            Point to = new Point(x, y);
            if (!board.isLegalMove(this, to))
                break;
            moves.add(new Move(location, to));
            y++;
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }


        /* right up */
        y = location.y() + 1;
        for (int x = location.x() + 1; x < 8; x++) {
            Point to = new Point(x, y);
            if (!board.isLegalMove(this, to))
                break;
            moves.add(new Move(location, to));
            y++;
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

        /* right down */
        y = location.y() - 1;
        for (int x = location.x() + 1; x < 8; x++) {
            Point to = new Point(x, y);
            if (!board.isLegalMove(this, to))
                break;
            moves.add(new Move(location, to));
            y--;
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }



        return moves;
    }
}
