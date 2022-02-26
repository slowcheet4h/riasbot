package riasbot;

import riasbot.board.Board;
import riasbot.board.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class BoardUI extends JPanel
{

    private Board board;
    public BoardUI(Board _board) {
        board = _board;
        setBackground(Color.BLACK);

    }

    public BoardUI setBoard(Board _board) {
        board = _board;
        return this;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        boolean white = true;
        for (int y = 0; y < 8; y++) {
            drawLine(g, white, y);
            white = !white;
        }

        for (Piece piece : board.pieces()) {
            g.drawImage(piece.image(), (7 - piece.location().x()) * 64, (7 -piece.location().y()) * 64, 64,64,this);
        }
    }

    private void drawLine(Graphics g, boolean white, int y) {
        boolean whiteCopy = white;
        for (int x = 0; x < 8; x++) {
            if (whiteCopy) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(x * 64, y * 64, 64, 64);
            whiteCopy ^= true;
        }
    }
}
