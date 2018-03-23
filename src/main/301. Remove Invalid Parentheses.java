class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, 0, '(', ')');
        return res;
    }

    private void dfs(List<String> res, String s, int start, int lastOk, char firstChar, char secondChar) {
        for (int count = 0, i = start; i < s.length(); i++) {
            if (s.charAt(i) ==  firstChar) count++;
            else if (s.charAt(i) == secondChar) count--;
            if (count < 0) {
                for (int j = lastOk; j <= i; j++) {
                    if (s.charAt(j) == secondChar && (j == lastOk || s.charAt(j - 1) != secondChar)) {
                        dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, firstChar, secondChar);
                    }
                }
                return;
            }
        }
        String next = new StringBuilder(s).reverse().toString();
        if (firstChar == '(') {
            dfs(res, next, 0, 0, secondChar, firstChar);
        } else {
            res.add(next);
        }
    }
}
