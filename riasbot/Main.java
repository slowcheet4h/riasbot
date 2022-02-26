package riasbot;

import riasbot.board.Board;
import riasbot.board.Move;
import riasbot.board.Point;
import riasbot.board.Team;
import riasbot.board.piece.Piece;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Board board = new Board();
        JFrame jFrame = new JFrame();
        BoardUI boardUI = new BoardUI(board);
        jFrame.setSize(512, 538);
        jFrame.add(boardUI);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        Random random = new Random();
        Team action = Team.WHITE;
        while (true) {


            Piece piece = selectRandomPiece(board, action);
            ArrayList<Move> moves = piece.validMoves();
            Point point = moves.get(random.nextInt(moves.size())).to();
            System.out.print(action.toString() + " ");
            board.move(piece, point);
            jFrame.repaint();



            if (action == Team.WHITE) {
                action = Team.BLACK;
            } else {
                action = Team.WHITE;
            }
            Thread.sleep(800);
        }

    }

    public static Piece selectRandomPiece(Board board, Team team) {
        Piece piece = null;
        do {
            piece = board.pieces().get(new Random().nextInt(board.pieces().size()));
        } while (piece == null || piece.team() != team || piece.validMoves().size() == 0);
        return piece;
    }
}
