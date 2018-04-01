

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
    //"[123,[456,[789]]]"
    public NestedInteger deserialize(String s) {
        Stack<Object> stk = new Stack<>();
        int sign = 1;
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '[') {
                stk.add("[");
            } else if (Character.isDigit(s.charAt(i))){
                int tmp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = 10 * tmp + s.charAt(++i) - '0';
                }
                NestedInteger ni = new NestedInteger();
                ni.setInteger(sign*tmp);
                stk.add(ni);
                if (i + 1 < s.length() && s.charAt(i + 1) == ',') {
                    i++;
                }
                sign = 1;
            } else if (s.charAt(i) == ']'){
                List<NestedInteger> list = new ArrayList<>();
                while (!stk.peek().equals("[")) {
                    list.add((NestedInteger) stk.pop());
                }
                stk.pop();
                Collections.reverse(list);
                NestedInteger ni = new NestedInteger();
                for (NestedInteger k : list) {
                    ni.add(k);
                }
                stk.add(ni);
            }
        }
        return (NestedInteger)stk.pop();
    }
}
