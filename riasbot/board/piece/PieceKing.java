package riasbot.board.piece;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;

import java.util.ArrayList;

public class PieceKing extends Piece
{

    public PieceKing(Team _team, Point _location, Board _board) {
        super('K', _team, _location, _board);
    }

    @Override
    public ArrayList<Move> validMoves() {
        ArrayList<Move> moves = new ArrayList<>();

        Point point1 = location().clone().addX(1);
        Point point2 = location().clone().addX(-1);
        Point point3 = location().clone().addY(1);
        Point point4 = location().clone().addY(-1);
        Point point5 = location().clone().add(1, 1);
        Point point6 = location().clone().add(-1, -1);
        Point point7 = location().clone().add(1, -1);
        Point point8 = location().clone().add(-1, 1);

        if (board.isLegalMove(this, point1)) {
            moves.add(new Move(location, point1));
        }

        if (board.isLegalMove(this, point2)) {
            moves.add(new Move(location, point2));
        }

        if (board.isLegalMove(this, point3)) {
            moves.add(new Move(location, point3));
        }

        if (board.isLegalMove(this, point4)) {
            moves.add(new Move(location, point4));
        }

        if (board.isLegalMove(this, point5)) {
            moves.add(new Move(location, point5));
        }

        if (board.isLegalMove(this, point6)) {
            moves.add(new Move(location, point6));
        }

        if (board.isLegalMove(this, point7)) {
            moves.add(new Move(location, point7));
        }

        if (board.isLegalMove(this, point8)) {
            moves.add(new Move(location, point8));
        }

        return moves;
    }
}
