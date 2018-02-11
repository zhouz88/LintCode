import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        Set<String> ret = new HashSet<>();
        dfs(ret, 0, 0, num, 0, target, '+', "");
        return new ArrayList<>(ret);
    }

    private void dfs(Set<String> list, long sum, long pre, String num, int start, int target, char sign, String s) {
        //System.out.println(s + " : " + sum + " : " + pre);
        int f = start;
        long tmp = 0;
        for (int i = f; i < num.length(); i++) {
            if (i == f + 1 && tmp == 0) {      //avoid "05"
                break;
            }
            tmp = tmp*10 + num.charAt(i) - '0';
            start = i;
            switch (sign) {
                case '+':
                    if (start + 1 == num.length()) {
                        sum += pre + tmp;
                        if (sum == (long)target) {
                            list.add((s+"+"+tmp).substring(1));
                        }

                        break;
                    }
                    dfs(list, sum + pre, tmp, num, start + 1, target, '+', new String(s)+"+"+tmp);
                    dfs(list, sum + pre, tmp, num, start + 1, target, '-',new String(s)+"+"+tmp);
                    dfs(list, sum + pre, tmp, num, start + 1, target, '*',new String(s)+"+"+tmp);
                    break;
                case '-':
                    if (start + 1 == num.length()) {
                        sum += pre- tmp;
                        if (sum == (long)target) {
                            list.add((s+"-"+tmp).substring(1));
                        }
                        break;
                    }
                    dfs(list, sum + pre, -tmp, num, start + 1,   target, '+',new String(s)+"-"+tmp);
                    dfs(list, sum + pre, -tmp, num, start + 1,   target, '-',new String(s)+"-"+tmp);
                    dfs(list, sum + pre, -tmp, num, start + 1,  target, '*',new String(s)+"-"+tmp);
                    break;
                case '*':
                    if (start + 1 == num.length()) {
                        sum += pre * tmp;
                        if (sum == (long)target) {
                            list.add((s+"*"+tmp).substring(1));
                        }
                        break;
                    }
                    dfs(list, sum , pre*tmp, num,start + 1,  target, '+',new String(s)+"*"+tmp);
                    dfs(list, sum , pre*tmp, num,start + 1,   target, '-',new String(s)+"*"+tmp);
                    dfs(list, sum , pre*tmp, num,start + 1,  target, '*',new String(s)+"*"+tmp);
                    break;
            }
        }
    }
}
