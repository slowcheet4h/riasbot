package riasbot.board;

import riasbot.board.piece.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private ArrayList<Piece> pieces = new ArrayList<>();
    private NestedList<Move> moves = new NestedList<>();

    private static String[][] _DEFAULT_BOARD = {
            {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"},
            {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"},
            {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"}
    };

    private static String[][] _EMPTY_BOARD = {
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
            {"**", "**", "**", "**", "**", "**", "**", "**"},
    };

    public Board() {
        pieces.add(new PieceRook(Team.WHITE, new Point(0, 0), this));
        pieces.add(new PieceKnight(Team.WHITE, new Point(1, 0), this));
        pieces.add(new PieceBishop(Team.WHITE, new Point(2, 0), this));
        pieces.add(new PieceRook(Team.WHITE, new Point(7, 0), this));
        pieces.add(new PieceKnight(Team.WHITE, new Point(6, 0), this));
        pieces.add(new PieceBishop(Team.WHITE, new Point(5, 0), this));

        pieces.add(new PieceKing(Team.WHITE, new Point(4, 0), this));
        pieces.add(new PieceQueen(Team.WHITE, new Point(3, 0), this));

        for (int i = 0; i < 8; i++) {
            pieces.add(new PiecePawn(Team.WHITE, new Point(i, 1), this));
        }

        pieces.add(new PieceRook(Team.BLACK, new Point(0, 7), this));
        pieces.add(new PieceKnight(Team.BLACK, new Point(1, 7), this));
        pieces.add(new PieceBishop(Team.BLACK, new Point(2, 7), this));


        pieces.add(new PieceRook(Team.BLACK, new Point(7, 7), this));
        pieces.add(new PieceKnight(Team.BLACK, new Point(6, 7), this));
        pieces.add(new PieceBishop(Team.BLACK, new Point(5, 7), this));


        pieces.add(new PieceKing(Team.BLACK, new Point(4, 7), this));
        pieces.add(new PieceQueen(Team.BLACK, new Point(3, 7), this));

        for (int i = 0; i < 8; i++) {
            pieces.add(new PiecePawn(Team.BLACK, new Point(i, 6), this));
        }



    }

    static boolean dontCheck;

    public boolean isLegalMove(Piece piece, Point point) {

        /* check if point is on board */
        if (point.x() > 7 || point.x() < 0 || point.y() > 7 || point.y() < 0)
            return false;

        /* check for friendly pieces */
        Piece victim = pieceFromPoint(point);

        if (victim != null && victim.team() == piece.team())
            return false;


        if (piece instanceof PiecePawn) {
            if (victim != null && piece.location().x() == point.x())
                return false;

            /* check if pawn is not blocked */
            if (victim == null && piece.location().x() != point.x()) {
                return false;
            }
        }

        /* check for check */
        /* check if making that move will make our king under attack */

        /* stackoverflow exception */
//        move(piece, point);
//        Piece king = piece(piece.team(), PieceKing.class);
//
//        for (Piece loopPiece : pieces) {
//            if (loopPiece == piece)
//                continue;
//            if (loopPiece.canCapture(king.location())) {
//                return false;
//            }
//        }
//        undo();


        return true;
    }

    public void move(Piece piece, Point to) {
        System.out.println(piece.location() + " to " + to);
        Piece atePiece = pieceFromPoint(to);
        moves.push(new Move(piece.location(), to));
        piece.move(to);
        if (atePiece != null) {
            moves.cursor().setAtePiece(atePiece);
            pieces.remove(atePiece);
        }
    }

    public void undo() {
        Move move = moves.pop();
        Piece piece = pieceFromPoint(move.to());
        piece.move(move.from());
        if (move.atePiece() != null) {
            pieces.add(move.atePiece());
        }
    }

    public Piece piece(Team team, Class<?> type) {
        for (Piece piece : pieces) {
            if (piece.team() == team && piece.getClass() == type) {
                return piece;
            }
        }

        return null;
    }

    public Piece pieceFromPoint(Point point) {
        for (Piece piece : pieces) {
            if (piece.location().x() == point.x() && piece.location().y() == point.y())
                return piece;
        }
        return null;
    }


    public void print() {
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x <= 7; x++) {
                Piece piece = pieceFromPoint(new Point(x, y));
                System.out.print(piece == null ? "** " : String.valueOf(piece.team().suffix) + piece.symbol() + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Piece> pieces() {
        return pieces;
    }
}
