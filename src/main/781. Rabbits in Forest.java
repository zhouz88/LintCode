import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i] + 1, map.getOrDefault(answers[i] + 1, 0) + 1);
        }
        for (int k : map.keySet()) {
            System.out.println(k +":"+ map.get(k));
            sum += (map.get(k)/k)*k;
            if (map.get(k)%k != 0) {
                sum += k;
            }
        }
        return sum;
    }
}
