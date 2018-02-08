import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        if (n <=0) {
           return false;
        }
        Set<Integer> set = new HashSet<>();
        while (true) {
            int total = 0;
            while (n != 0) {
                int m = n%10;
                n = n/10;
                total += m*m;
            }
            if (total == 1) {
                return true;
            }
            if (set.contains(total)) {
                return false;
            }
            set.add(total);
            n = total;//wrong 1
        }
    }
}
