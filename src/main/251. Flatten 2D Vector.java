import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    private Iterator<Integer> itr;
    private List<List<Integer>> vec2d;
    private int idx = 0;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        if (idx >= vec2d.size()) return false;
        if (itr == null) {
            itr = vec2d.get(idx).iterator();
        } 
        if (itr.hasNext()) {
            return true;
        }
        idx++;
        while (idx < vec2d.size() && vec2d.get(idx).size() == 0) {
            idx++;
        }
        if (idx >= vec2d.size()) return false;
        itr = vec2d.get(idx).iterator();
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
