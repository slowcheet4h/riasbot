package riasbot.board;

public enum Team {
    WHITE('w'),
    BLACK('b');

    char suffix;

    Team(char _suffix) {
        suffix = _suffix;
    }

    public char suffix() {
        return suffix;
    }

    public Team opponent() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}