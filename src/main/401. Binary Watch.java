import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            get(res, i, num - i);
        }
        return res;
    }

    private void get(List<String> res, int minutes, int hours) {
        if (minutes < 0 || minutes > 6 || hours > 4 || hours < 0) {
            return;
        }
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        dfsMinutes(A, 6, minutes, 0,  0);
        dfsHour(B, 4, hours, 0,0);
        for (int k : A) {
            for (int t : B) {
                String K = k + "";
                if (K.length() < 2) {
                    K = "0" + K;
                }
                res.add(t + ":" + K);
            }
        }
    }

    private void dfsMinutes(List<Integer> A, int total, int minutes, int sum, int start) {
        if (minutes == 0 && sum < 60) {
            A.add(sum);
            return;
        } 
        if (minutes == 0) {
            return;
        }
        for (int i = start; i < total; i++) {
            sum += (1 << i);
            dfsMinutes(A, total, minutes - 1, sum, i + 1);
            sum -= (1 << i);
        }
    }

    private void dfsHour(List<Integer> A, int total, int minutes, int sum, int start) {
        if (minutes == 0 && sum < 12) {
            A.add(sum);
            return;
        }
        if (minutes == 0) {
            return;
        }
        for (int i = start; i < total; i++) {
            sum += (1 << i);
            dfsHour(A, total, minutes - 1, sum, i + 1);
            sum -= (1 << i);
        }
    }
}
