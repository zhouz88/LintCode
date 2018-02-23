import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list  = new ArrayList<>();
            list.add(0);
            return list;
        }

        List<Integer> tmpList = grayCode(n - 1);
        List<Integer> tmp2List = new ArrayList<>(tmpList);
        Collections.reverse(tmp2List);
        for (int i = 0; i < tmp2List.size(); i++) {
            tmp2List.set(i, tmp2List.get(i) | (1 << (n - 1)));
        }
        tmpList.addAll(tmp2List);
        return tmpList;
    }
}
