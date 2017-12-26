/**
 22. Flatten List

    Description
    Notes
    Testcase
    Judge

Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
Notice

If the element in the given list is a list, it can contain list too.
Have you met this question in a real interview?
Example

Given [1,2,[1,2]], return [1,2,1,2].

Given [4,[3,[2,[1]]]], return [4,3,2,1].
Challenge 
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> res) {
        // Write your code here
        if (res == null) 
           throw new RuntimeException();
           
        while (true) {
            List<NestedInteger> tmp = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).isInteger()) {
                    tmp.add(res.get(i)); 
                } else {
                    NestedInteger p = res.get(i);
                    tmp.addAll(p.getList());
                    flag = false;
                }
            }
            res = tmp;
            if (flag) break;
        }
        List<Integer> ret = new ArrayList<>();
        for (NestedInteger k : res) {
            ret.add(k.getInteger());
        }
        return ret;
    }
}
