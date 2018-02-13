import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        return get(depth, nestedList);
    }

    private int get(int depth, List<NestedInteger> nestedList) {
        int total = 0;
        for (NestedInteger k : nestedList) {
            if (k.isInteger()) {
               total += k.getInteger()*depth;
            } else {
               total+= get(depth - 1, k.getList());//wrong1
            }
        }
        return total;
    }

    private int getDepth(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int max = 0;
        for (NestedInteger k : nestedList) {
            if (!k.isInteger()) {
                max = Math.max(max, 1 + getDepth(k.getList()));
            } else {
                max = Math.max(1, max);
            }
        }
        return max;
    }

//     public interface NestedInteger {
//       // Constructor initializes an empty nested list.
//      public NestedInteger();

//             // Constructor initializes a single integer.
//               public NestedInteger(int value);

//               // @return true if this NestedInteger holds a single integer, rather than a nested list.
//               public boolean isInteger();

//               // @return the single integer that this NestedInteger holds, if it holds a single integer
//               // Return null if this NestedInteger holds a nested list
//               public Integer getInteger();

//               // Set this NestedInteger to hold a single integer.
//               public void setInteger(int value);

//               // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//             public void add(NestedInteger ni);

//              // @return the nested list that this NestedInteger holds, if it holds a nested list
//              // Return null if this NestedInteger holds a single integer
//               public List<NestedInteger> getList();
//   }
}
