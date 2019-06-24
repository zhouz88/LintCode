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

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(num, 0, target, new StringBuilder(), 0, 0, res);
        return res;
    }

    private void dfs(String num, int start, int target, StringBuilder stringBuilder, long sum, long pre,List<String> res) {
        if (start == 0) {
            long temp = 0;
            for (int i = start; i < num.length(); i++) {
                temp = temp * 10 + num.charAt(i) - '0';
                if (i > start && num.charAt(start) == '0') break;
                int len = stringBuilder.length();
                stringBuilder.append(temp);
                dfs(num, i + 1, target, stringBuilder, sum, temp, res);
                stringBuilder.setLength(len);
            }
            return;
        }
        if (start == num.length()) {
            sum += pre;
            if (sum == (long) target) {
                res.add(stringBuilder.toString());
            }
            return;
        }
        long temp = 0;
        for (int i = start; i < num.length(); i++) {
            temp = temp * 10 + num.charAt(i) - '0';
            if (i > start && num.charAt(start) == '0') break;
            int len = stringBuilder.length();
            stringBuilder.append("+" + temp);
            dfs(num, i + 1, target, stringBuilder, sum + pre, temp, res);
            stringBuilder.setLength(len);
            stringBuilder.append("-" + temp);
            dfs(num, i + 1, target, stringBuilder, sum + pre, -temp, res);
            stringBuilder.setLength(len);
            stringBuilder.append("*" + temp);
            dfs(num, i + 1, target, stringBuilder, sum, pre * temp, res);
            stringBuilder.setLength(len);
        }
    }
}
