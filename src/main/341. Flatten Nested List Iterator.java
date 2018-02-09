import java.util.Iterator;
import java.util.List;
import java.util.Stack;


public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
         for (int i = nestedList.size() - 1; i>=0; i--) {
             stack.add(nestedList.get(i));
         }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
         while (!stack.isEmpty()) {
             if (stack.peek().isInteger()) {
                 return true;
             }
             
             NestedInteger tmp = stack.pop();
             for (int i = tmp.getList().size() - 1; i >=0 ; i--) {
                 stack.add(tmp.getList().get(i));
             }
         }
         return false;
    }
    
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
