import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]) == 0 ?
                        Integer.compare(o1[1], o2[1]) :
                        Integer.compare(o2[0], o1[0]);
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            int[] tmp = people[i];
            res.add(tmp[1], tmp);
        }

        int[][] ret = new int[people.length][];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
