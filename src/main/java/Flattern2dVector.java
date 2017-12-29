/*

601. Flatten 2D Vector 
 Description
 Notes
 Testcase
 Judge
Implement an iterator to flatten a 2d vector.

Have you met this question in a real interview? Yes
Example
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].



*/

public class Vector2D implements Iterator<Integer> {
    int col = 0;
    int row = -1;
    int probecol;
    int proberow;
    List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.list = vec2d;
    }

    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()) 
            throw new RuntimeException("No more nubmer");
            
        col = probecol;
        row = proberow;
        
        return list.get(col).get(row);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (col >= list.size()) 
            return false;
        if (row + 1 < list.get(col).size()) {
            proberow = row + 1;
            probecol = col;
            return true;
        } else {
            proberow = 0;
            probecol = col + 1;
            while (probecol < list.size() && list.get(probecol).size() < 1) 
                probecol++;
            return probecol < list.size();
        }
        
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
