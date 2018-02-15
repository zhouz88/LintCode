import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    List<Iterator<Integer>> list = new ArrayList<>();
    List<List<Integer>> vec2d;
    Iterator<Integer> itr;
    int i = 0;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        for (int i = 0; i < vec2d.size(); i++) {
            list.add(vec2d.get(i).iterator());
        }
        if (vec2d.size() != 0) {
            itr = list.get(0);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return -1;
        }
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        if (itr == null) {
            return false;}
        if (itr .hasNext()) {
            return true;
        }
        i++;
        if (i == list.size()) {
            return false;
        }
        while (i < list.size() && !list.get(i).hasNext()) {
            i++;
        }
        if (i < list.size()) {
            itr = list.get(i);
        }
        return i < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
