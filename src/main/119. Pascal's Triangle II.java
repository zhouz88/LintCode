import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        if (rowIndex == 0) {
            return list;
        }

        list.add(1);

        if(rowIndex == 1) {
            return list;
        }

        int i = 1;

        while (i < rowIndex) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                tmpList.add(list.get(j) + list.get(j + 1));
            }
            tmpList.add(1);
            list = tmpList;
            i++;
        }
        
        return list;
    }
}
