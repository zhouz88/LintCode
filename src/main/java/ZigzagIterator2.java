public class ZigzagIterator2 {
    /*
    * @param vecs: a list of 1d vectors
    541. Zigzag Iterator II 
 Description
 Notes
 Testcase
 Judge
Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Have you met this question in a real interview? Yes
Example
Given k = 3 1d vectors:

[1,2,3]
[4,5,6,7]
[8,9]
    */
    int col = -1;
    int row = 0;
    int probecol;
    int proberow;
    
    List<List<Integer>> list;
    
    int m;
    int max = 0;
    
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        this.list = vecs;
        m = list.size();
        for (List<Integer> tmp : list) {
            max = Math.max(max, tmp.size());
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (!hasNext()) 
            throw new RuntimeException();
            
        row = proberow;
        col = probecol;
        System.out.println(list.get(col).get(row));
        return list.get(col).get(row);
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        
        probecol = col + 1;
        proberow = row;
        
        while (proberow <= max) {
            while (probecol < m && list.get(probecol).size() <= proberow) 
                 probecol++;
             
            if (probecol == m) {
                probecol = 0;
                proberow = proberow + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
