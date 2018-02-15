import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        
        //base cases;
        if (numRows == 0) {
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);
        if (numRows == 1) {
            return ret;
        }
        
        //general
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                newList.add(list.get(j) + list.get(j+1));
            }
            newList.add(1);
            ret.add(newList);
            list = newList;
        }
        return ret;
    }
}
