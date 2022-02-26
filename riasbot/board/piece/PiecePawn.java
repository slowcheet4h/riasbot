package riasbot.board.piece;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;

import java.util.ArrayList;

public class PiecePawn extends Piece {

    private boolean firstMove = true;

    public PiecePawn(Team _team, Point _location, Board _board) {
        super('P', _team, _location, _board);
    }

    @Override
    public ArrayList<Move> validMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        if (firstMove) {
            Point moveLocation = location().clone().addY(team == Team.WHITE ? 2 : - 2);
            if (board.isLegalMove(this, moveLocation)) {
                moves.add(new Move(location(), moveLocation));
            }
        }

        Point oneForward = location().clone().addY(team == Team.WHITE ? 1 : - 1);
        if (board.isLegalMove(this, oneForward)) {
            moves.add(new Move(location(), oneForward));
        }


        Point attacking1 = location().clone().add(1, team == Team.WHITE ? 1 : - 1);
        if (board.isLegalMove(this, attacking1)) {
            moves.add(new Move(location(), attacking1));
        }

        Point attacking2 = location().clone().add(-1, team == Team.WHITE ? 1 : - 1);
        if (board.isLegalMove(this, attacking2)) {
            moves.add(new Move(location(), attacking2));
        }


        return moves;
    }

    @Override
    public void move(Point _location) {
        firstMove = false;
        super.move(_location);
    }
}
