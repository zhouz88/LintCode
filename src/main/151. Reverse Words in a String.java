public class Solution {
    public String reverseWords(String s) {
        char[] t = (" " + s).toCharArray();
        reverse(0, t.length - 1, t);
        int idx = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != ' ') {
                t[idx++] = t[i];
            } else if (t[i] == ' ' && idx > 0 && t[idx - 1] != ' ') {
                t[idx++] = ' ';
            } 
        }
        int pre = 0;
        for (int i = 0; i < idx; i++) {
            if (t[i] == ' ') {//保证前边有一个空格 必须在s前+ ” “；
                reverse(pre, i - 1, t);
                pre = i + 1;
            } 
        }
        return String.valueOf(t, 0, idx).trim();
    }

    private void reverse(int i, int j, char[] t) {
        while (i < j) {
            char tmp = t[i];
            t[i++] = t[j];
            t[j--] = tmp;
        }
    }
}
