package riasbot.board.piece;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;

import java.util.ArrayList;

public class PieceQueen extends Piece {


    public PieceQueen(Team _team, Point _location, Board _board) {
        super('Q', _team, _location, _board);
    }

    @Override
    public ArrayList<Move> validMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        // look right
        for (int x = location().x() + 1; x < 8; x++) {
            /* check for friendly pieces */
            Point to = new Point(x, location().y());
            if (!board.isLegalMove(this, to)) {
                break;
            }
            moves.add(new Move(location(), new Point(x, location().y())));
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

        /* look left */
        for (int x = location().x() - 1; x > 0; x--) {
            /* check for friendly pieces */
            Point to = new Point(x, location().y());
            if (!board.isLegalMove(this, to)) {
                break;
            }
            moves.add(new Move(location(), to));
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

        /* look up */
        for (int y = location.y() + 1; y < 8; y++) {
            /* check for friendly pieces */
            Point to = new Point(location.x(), y);
            if (!board.isLegalMove(this, to)) {
                break;
            }
            moves.add(new Move(location(), to));
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

        /* look down */
        for (int y = location.y() - 1; y > 0; y--) {
            /* check for friendly pieces */
            Point to = new Point(location.x(), y);
            if (!board.isLegalMove(this, to)) {
                break;
            }
            moves.add(new Move(location(), to));
            Piece piece = board.pieceFromPoint(to);
            if (piece != null) {
                break;
            }
        }

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
