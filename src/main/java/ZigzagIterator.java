public class ZigzagIterator {
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    

    */
    
    private List<Integer> l1;
    private List<Integer> l2;
    private int col = 1;
    private int idxA = -1;
    private int idxB = -1;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        l1 = v1;
        l2 = v2;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (col == 0) {
            if (idxB + 1 < l2.size()) {
                col = 1;
                return l2.get(++idxB);
            } else {
                if (idxA + 1 > l1.size()) {
                    throw new RuntimeException();
                }
                return l1.get(++idxA);
            }
        } else {
             if (idxA + 1 < l1.size()) {
                col = 0;
                return l1.get(++idxA);
            } else {
                if (idxB + 1 > l2.size()) {
                    throw new RuntimeException();
                }
                return l2.get(++idxB);
            }
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        if (col == 0) {
            if (idxB + 1 == l2.size()) {
                return idxA + 1 < l1.size();
            } else {
                return true;
            }
        } else {
            if (idxA + 1 == l1.size()) {
                return idxB + 1 < l2.size();
            } else {
                return true;
            }
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
