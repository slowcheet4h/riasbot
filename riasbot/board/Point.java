package riasbot.board;

public class Point {

    private int x;
    private int y;
    private static final String columns = "abcdefgh";

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Point clone() {
        return new Point(x, y);
    }

    public Point addX(int _x) {
        x += _x;
        return this;
    }

    public Point add(int _x, int _y) {
        x += _x;
        y += _y;
        return this;
    }

    public Point addY(int _y) {
        y += _y;
        return this;
    }

    @Override
    public String toString() {
        return columns.charAt(x) + "" + (y + 1);
    }
}
