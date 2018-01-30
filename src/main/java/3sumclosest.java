import java.util.Arrays;

public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length <= 2) {
            return -1;
        }
        int i;

        Arrays.sort(numbers);
        int ret = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int tar = target - numbers[i] - numbers[j];
                int l = j + 1;
                int r = numbers.length - 1;
                while (l + 1 < r) {
                    int mid = l + ((r - l) >> 1);
                    if (numbers[mid] == tar) {
                        return target;
                    } else if (numbers[mid] > tar) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
                if (2*tar > numbers[l] + numbers[r]) {
                    int total = numbers[r] + numbers[i] + numbers[j];
                    if (Math.abs(total - target) < ret) {
                        ret = Math.abs(total - target);
                        ans = total;
                    }
                } else {
                    int total = numbers[l] + numbers[i] + numbers[j];
                    if (Math.abs(total - target) < ret) {
                        ret = Math.abs(total - target);
                        ans = total;
                    }
                }
            }
        }

        return ans;
    }
}


//o(n2)
public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        
        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return bestSum;
    }
