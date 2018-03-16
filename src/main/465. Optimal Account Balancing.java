import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> debt = new HashMap<>();
        for(int[] t : transactions){       
            debt.put(t[0], debt.getOrDefault(t[0], 0) - t[2]);
            debt.put(t[1], debt.getOrDefault(t[1], 0) + t[2]);
        }

        int[] account = new int[debt.size()];
        int len = 0;

        for(int v : debt.values()){        
            if(v != 0){
                account[len++] = v;
            }
        }

        if(len == 0)
            return 0;

        int[] dp = new int[1 << len];
        Arrays.fill(dp, 999999999);

        for(int i = 1; i <  dp.length; i++){
            int sum = 0, count = 0;
            for (int j = 0; j < len; j++){
                if ((1 << j & i) != 0){
                    sum += account[j];
                    count++;
                }
            }//状态 i 对应的 总和；
            if (sum == 0){
                dp[i] = count - 1;
                for (int sub = 1; sub < i; sub++){
                    if (((i & sub) == sub) && dp[sub] + dp[i - sub] < dp[i]){
                        System.out.println(Integer.toBinaryString(sub));
                        System.out.println(Integer.toBinaryString(i - sub));
                        System.out.println(Integer.toBinaryString(i));
                        System.out.println("end");
                        dp[i] = dp[sub] + dp[i - sub];
                    }
                }
            }
        }
        return dp[dp.length - 1];

    }
}
