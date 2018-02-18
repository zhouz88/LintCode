import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        // unsigned int max 31 bit set.
        for (int i = 31; i >= 0;i--) {
            int candidate = max | (1 << i);
            
            mask = mask | (1 << i);
            
            Set<Integer> set = new HashSet<>();
            
            for (int num : nums){
                set.add(num & mask);
            }
            
            for (int num : nums) {
                
                int prefix = num & mask;
                
                if (set.contains(candidate ^ prefix)) {
                    max = candidate;
                    break;
                }
                //定理 if A ^ B = C THEN C ^ B= A OR C ^ A =B;
                
                
                // 11001   25
                // 00101   5
                // 00011   3
                // 01000   8
                // 00010   2
                // 01010   10
            }
        }
        return max;
    }
}
