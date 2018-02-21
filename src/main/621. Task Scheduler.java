class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) {
            return 0;
        }
        
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        Arrays.sort(count);
        
        int i = 25;
        int max = count[i];
        
        while (i >= 0 && count[i] == max) {
            i--;
        }
        
        return Math.max(tasks.length, (max - 1) * (n + 1) + 25 - i);
    }
}
