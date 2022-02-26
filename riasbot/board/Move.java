package riasbot.board;

import riasbot.board.piece.Piece;

import java.util.Objects;

public class Move {

    private Point from;
    private Point to;
    private Piece atePiece;

    public Move(Point _from, Point _to) {
        from = _from.clone();
        to = _to.clone();
    }

    public Move setAtePiece(Piece _atePiece) {
        atePiece = _atePiece;
        return this;
    }

    public Point from() {
        return from;
    }

    public Point to() {
        return to;
    }

    public Piece atePiece() {
        return atePiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(from, move.from) && Objects.equals(to, move.to) && Objects.equals(atePiece, move.atePiece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, atePiece);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Move{");
        sb.append("from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", atePiece=").append(atePiece);
        sb.append('}');
        return sb.toString();
    }
}
