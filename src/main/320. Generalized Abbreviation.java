import java.util.ArrayList;
import java.util.List;
/*
320. Generalized Abbreviation
DescriptionHintsSubmissionsDiscussSolution
Pick One
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
S
*/
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String word, int i, List<Object> list, List<String> res) {
        if (i == word.length()) {
            StringBuilder sb = new StringBuilder();
            for (Object t : list) {
                sb.append(t);
            }
            res.add(sb.toString());
            return;
        }
        list.add(word.charAt(i));
        dfs(word, i + 1, list, res);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            list.add(1);
            dfs(word, i + 1, list, res);
            list.remove(list.size() - 1);
        } else if ((list.get(list.size() - 1) instanceof Integer)) {
            int tmp = (Integer) list.get(list.size() - 1);
            tmp++;
            list.remove(list.size() - 1);
            list.add(tmp);
            dfs(word, i + 1, list, res);
            list.remove(list.size() - 1);
            list.add(tmp - 1);
        } else if (!(list.get(list.size() - 1) instanceof Integer)) {
            list.add(1);
            dfs(word, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    } 
}
