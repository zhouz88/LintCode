 //input "A1B2"
class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] t = S.toCharArray();
        List<String> ret = new ArrayList<>();
        ret.add(S.toLowerCase());
        update(ret, 0, t);
        System.out.println(Arrays.toString(t));
        //[A, 1, B, 2] 最后一步带有回溯 最终的t 不变
        return ret;
    }

    private void update(List<String> ret, int i, char[] t) {
        while (i < t.length && !Character.isLetter(t[i])) {
            i++;
        }
        if (i == t.length) {
            return;
        }
        char tmp = t[i];
        t[i] = Character.toUpperCase(t[i]);
        ret.add(new String(t));
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
        ret.add(S.toLowerCase());
        update(ret, 0, t);
        System.out.println(Arrays.toString(t));
        //[a, 1, b, 2] t改变
        return ret;
    }

    private void update(List<String> ret, int i, char[] t) {
        while (i < t.length && !Character.isLetter(t[i])) {
            i++;
        }
        if (i == t.length) {
            return;
        }
        char tmp = t[i];
        t[i] = Character.toUpperCase(t[i]);
        ret.add(new String(t));
        update(ret, i + 1, t);
        
        t[i] = Character.toLowerCase((t[i]));
        update(ret, i + 1, t);
        //t[i] = tmp;
    }
}
