package riasbot.board.piece;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public abstract class Piece {

    protected Team team;
    protected Point location;
    protected Board board;
    protected char symbol;
    protected BufferedImage image;

    public BufferedImage image() {
        return image;
    }

    public Piece(char _symbol, Team _team, Point _location, Board _board) {
        team = _team;
        location = _location;
        board = _board;
        symbol = _symbol;

        try {
            image = ImageIO.read(new File("src/res/" + team.name().toLowerCase(Locale.ROOT) + "/" + symbol + ".png"));
        } catch (IOException e) {

        }
    }

    public Board board() {
        return board;
    }

    public Point location() {
        return location;
    }

    public char symbol() {
        return symbol;
    }

    public boolean canCapture(Point point) {
        for (Move move : validMoves()) {
            if (move.to().equals(point)) {
                return true;
            }
        }
        return false;
    }

    public void move(Point _location) {
        location = _location;
    }

    public Team team() {
        return team;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Piece{");
        sb.append("team=").append(team);
        sb.append(", location=").append(location);
        sb.append(", board=").append(board);
        sb.append(", symbol=").append(symbol);
        sb.append('}');
        return sb.toString();
    }

    public abstract ArrayList<Move> validMoves();
}
