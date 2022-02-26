package riasbot.board;

import java.util.ArrayList;
import java.util.List;

public class NestedList<X> {

    private List<X> list;

    public NestedList() {
        list = new ArrayList<>();
    }

    public X push(X _x) {
        list.add(_x);
        return _x;
    }

    public X pop() {
        return list.remove(list.size() - 1);
    }

    public void cut(int index) {
        for (int i = list.size(); i > index; i--)
            list.remove(i);
    }

    public X cursor() {
        return list.get(list.size() - 1);
    }

}
