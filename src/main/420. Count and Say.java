public class Solution {
    /*
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
        String tmp = 1 + "";
        while (n > 1) {
            tmp = generateSequence(tmp);
            n--;
        }
        return tmp;
    }
    
    private String generateSequence(String s) {
        char[] array = s.toCharArray();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(array[i - 1]);
                cnt = 1;
            }
        }
        if (cnt != 0) {
            sb.append(cnt);
            sb.append(array[array.length - 1]);
        }
        return sb.toString();
    }
}
