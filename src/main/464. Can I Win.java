import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int state = (1 << (maxChoosableInteger)) - 1;
        
        if ((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) {//wrong 2
            return false;
        }
        
        Map<String, Boolean> map = new HashMap<>();
        return dfs(state, desiredTotal, maxChoosableInteger, 0, map);
    }

    private boolean dfs(int state, int desiredTotal, int maxChoosableInteger, int sum, Map<String, Boolean> map) {
        String tmp = state + " " + sum;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state & (1 << i)) == 0) continue;
            if (i + sum + 1 >= desiredTotal) {
                return true;
            }
        }

        if (map.containsKey(tmp)) {
            return map.get(tmp);
        }

        boolean flag = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state & (1 << i)) == 0) continue;
            int newState = state - (1 << i);
            if (!dfs(newState, desiredTotal, maxChoosableInteger, sum + (i + 1), map)) { //wrong 1 nodt flag || ....cost time
               flag = true;
               break;
            }
        }

        if (flag) {
            map.put(tmp, true);
        } else {
            map.put(tmp, false);
        }
        return map.get(tmp);
    }
}
