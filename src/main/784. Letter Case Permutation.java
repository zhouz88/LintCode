 //input "A, 1, B, 2, c, 3"
class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] t = S.toCharArray();
        List<String> ret = new ArrayList<>();
        update(ret, 0, t);
     //[A, 1, B, 2, c, 3] 带有回溯 最后的t
        return ret;
    }

    private void update(List<String> ret, int i, char[] t) {
        while (i < t.length && !Character.isLetter(t[i])) {
            i++;
        }
        if (i == t.length) {
            ret.add(new String(t));
            return;
        }
        char tmp = t[i];
        t[i] = Character.toUpperCase(t[i]);
        update(ret, i + 1, t);
        t[i] = Character.toLowerCase((t[i]));
        update(ret, i + 1, t);
        t[i] = tmp;
    }
}
//不带回溯 
class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] t = S.toCharArray();
        List<String> ret = new ArrayList<>();
        update(ret, 0, t);
     //[a, 1, b, 2, c, 3] 不带回溯最终状态
        return ret;
    }

    private void update(List<String> ret, int i, char[] t) {
        while (i < t.length && !Character.isLetter(t[i])) {
            i++;
        }
        if (i == t.length) {
            ret.add(new String(t));
            return;
        }
       // char tmp = t[i];
        t[i] = Character.toUpperCase(t[i]);
        update(ret, i + 1, t);
        t[i] = Character.toLowerCase((t[i]));
        update(ret, i + 1, t);
        //t[i] = tmp;
    }
}
