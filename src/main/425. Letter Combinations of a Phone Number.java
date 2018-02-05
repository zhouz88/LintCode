import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> ret = new ArrayList<>();

        if (digits == null) {
            throw new RuntimeException();
        }
         
        if (digits.length() == 0) {
            return ret;
        }// Wrong answer 1
        
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        dfs(0, digits, map, new StringBuilder(), ret);
        return ret;
    }

    private void dfs(int start, String digits, char[][] map, StringBuilder stringBuilder, List<String> ret) {
        if (start == digits.length()) {
            ret.add(stringBuilder.toString());
            return;
        }
        for (char ch : map[digits.charAt(start) - '0']) {
            stringBuilder.append(ch);
            dfs(start + 1, digits, map, stringBuilder, ret);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
