class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length ; i++) {
            int k = nums[i];
            if (k == num) {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    num = k;
                    cnt = 1;//wrong 1
                }
            }
        }
        return num;
    }
}


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        int first = nums[0], second = nums[0];
        int cnt1 = 0, cnt2 = 0;
        for (int k : nums) {
            if (first == k) {
                cnt1++;
            } else if (second == k) {
                cnt2++;
            } else if (cnt1 == 0){
                first = k;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                second = k;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0;
        cnt2 = 0;
        for (int k : nums) {
            if (k == first) {
                cnt1++;
            } else if (k == second){
                cnt2++;
            }
        }
        if (cnt1 > nums.length/3) {
            ret.add(first);
        }
        if (cnt2 > nums.length/3) {
            ret.add(second);
        }
        return ret;
    }
}
