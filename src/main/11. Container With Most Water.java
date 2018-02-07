class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);

        while (l < r) { // height中较小者在下一搜索中被排除，因为如果含有该高度则无论（l + 1到 r - 1）的值是大于还是小于它， 最终结果都会减小
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            int tmp = Math.min(height[l], height[r]) * (r - l);
            if (tmp > max) {
                max = tmp;
            }
        }
        
        return max;
    }
}

//
