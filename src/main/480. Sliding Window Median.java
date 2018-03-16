import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public double[] medianSlidingWindow(int[] A, int k) {
        int n = A.length;
        long[] nums = new long[A.length];
        for (int i = 0; i < n; i++) {
            nums[i] = (long)A[i];
        }
        double[] res = new double[n - k + 1];
        int idx = 0;
        TreeMap<Long, Integer> upMap = new TreeMap<>();
        TreeMap<Long, Integer> downMap = new TreeMap<>();
        int upNum = 0;
        int downNum = 0;
        for (int i =  0; i < nums.length; i++) {
            if (upNum == 0 && downNum == 0) {
                downMap.put((long)nums[i], downMap.getOrDefault(nums[i], 0) + 1);
                downNum++;
            } else if (upNum == downNum) {
                Long max = upMap.keySet().iterator().next();
                if (nums[i] <= max) {
                    downMap.put((long)nums[i], downMap.getOrDefault(nums[i], 0) + 1);
                } else {
                    upMap.put((long)nums[i], upMap.getOrDefault(nums[i], 0) + 1);
                    Integer t = upMap.get(max);
                    if (t == 1) {
                        upMap.remove(max);
                    } else {
                        upMap.put(max,  t - 1);
                    }
                    downMap.put(max, downMap.getOrDefault(max, 0) + 1);
                }
                downNum++;
            } else if (upNum < downNum){
                Long max = downMap.descendingKeySet().iterator().next();
                if (max <= nums[i]) {
                    upMap.put(nums[i], upMap.getOrDefault(nums[i], 0) + 1);
                } else {
                    Integer t = downMap.get(max);
                    if (t == 1) {
                        downMap.remove(max);
                    } else {
                        downMap.put(max,  t - 1);
                    }
                    upMap.put(max, upMap.getOrDefault(max, 0) + 1);
                    downMap.put(nums[i], downMap.getOrDefault(nums[i], 0) + 1);
                }
                upNum++;
            }
            if (i - k + 1 >= 0) {
                if (k%2==0) {
                    res[idx++] = (upMap.keySet().iterator().next() + downMap.descendingKeySet().iterator().next())/2.0;
                } else {
                    res[idx++] = downMap.descendingKeySet().iterator().next() * 1.0;
                }
                if (k%2==0) {
                    if (upMap.containsKey(nums[i - k + 1])) {
                        Integer t = upMap.get(nums[i - k + 1]);
                        if (t == 1) {
                            upMap.remove(nums[i - k + 1]);
                        } else {
                            upMap.put(nums[i - k + 1],  t - 1);
                        }
                        upNum--;
                    } else {
                        Integer t = downMap.get(nums[i - k + 1]);
                        if (t == 1) {
                            downMap.remove(nums[i - k + 1]);
                        } else {
                            downMap.put(nums[i - k + 1],  t - 1);
                        }
                        Long min = upMap.keySet().iterator().next();
                        Integer v = upMap.get(min);
                        if (v == 1) {
                            upMap.remove(min);
                        } else {
                            upMap.put(min,  v - 1);
                        }
                        downMap.put(min, downMap.getOrDefault(min, 0) + 1);
                        upNum--;
                    }
                } else {
                    if (downMap.containsKey(nums[i - k + 1])) {
                        Integer t = downMap.get(nums[i - k + 1]);
                        if (t == 1) {
                            downMap.remove(nums[i - k + 1]);
                        } else {
                            downMap.put(nums[i - k + 1], t - 1);
                        }
                        downNum--;
                    } else {
                        Integer t = upMap.get(nums[i - k + 1]);
                        if (t == 1) {
                            upMap.remove(nums[i - k + 1]);
                        } else {
                            upMap.put(nums[i - k + 1], t - 1);
                        }
                        Long max = downMap.descendingKeySet().iterator().next();
                        Integer v = downMap.get(max);
                        if (v == 1) {
                            downMap.remove(max);
                        } else {
                            downMap.put(max,  v - 1);
                        }
                        upMap.put(max, upMap.getOrDefault(max, 0) + 1);
                        downNum--;
                    }
                }
            }
        }
        return res;
    }
}
