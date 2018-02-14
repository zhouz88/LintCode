import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        //corner case.....
        if (n == 0) {
            return ret;
        }
        update(ret, n, new char[2*n], 0, 0); //char 数组默认'\u0000'就和 int[] 默认 0一样
        
        return ret;
    }

    private void update(List<String> ret, int n, char[] s, int l, int r) {
        if (l > n) {
            return;  //leaf out
        }
        if (l == n && r == n) {
            System.out.println(l);
            ret.add(new String(s));
            return;
        }
        if (l > r) {  
            s[l + r] = '(';
            update(ret, n, s, l + 1, r);
            
            s[l + r] = ')';
            update(ret, n, s, l, r + 1);
        } else if (l == r) {
            s[l + r] = '(';
            update(ret, n, s, l + 1, r);
        }
    }
}
