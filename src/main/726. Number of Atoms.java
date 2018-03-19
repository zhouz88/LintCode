import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isUpperCase(formula.charAt(i)) && i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                String tmp = formula.charAt(i) + "" + formula.charAt(i + 1);
                stack.add(tmp);
                i++;//bug 3
                if (i + 1 == formula.length() || !Character.isDigit(formula.charAt(i + 1))) {
                    stack.add(1);
                }
            } else if (Character.isUpperCase(formula.charAt(i)) && (i + 1 == formula.length() || (i + 1 < formula.length() && !Character.isLowerCase(formula.charAt(i + 1))))) {
                String tmp = formula.charAt(i) + "";
                stack.add(tmp);
                if (i + 1 == formula.length() || !Character.isDigit(formula.charAt(i + 1))) {
                    stack.add(1);
                }
            } else if (Character.isDigit(formula.charAt(i))) {
                int tmp = formula.charAt(i) - '0';
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    tmp = tmp * 10 + formula.charAt(++i) - '0';
                }
                stack.add(tmp);
            } else if (formula.charAt(i) == '(') {
                stack.add("(");
            } else if (formula.charAt(i) == ')') {
                int tmp = 1;
                if (i + 1 < formula.length() || Character.isDigit(formula.charAt(i + 1))) {
                    i++;//bug2
                    tmp = formula.charAt(i) - '0';
                    while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                        tmp = tmp * 10 + formula.charAt(++i) - '0';
                    }
                }
                Map<String, Integer> map = new HashMap<>();
                while (!stack.peek().equals("(")) {
                    Integer count = (Integer) stack.pop();
                    String a = (String) stack.pop();
                    map.put(a, map.getOrDefault(a, 0) + count);
                }
                stack.pop();//bug1
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    stack.add(e.getKey());
                    stack.add(e.getValue()*tmp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < stack.size() - 1; i+=2) {
            String tmp = (String)stack.get(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + (Integer)stack.get(i + 1));//bug2
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() != 1)sb.append(e.getValue());
        }
        return sb.toString();
    }
}
/*

formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
 */
