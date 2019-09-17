import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String decodeString(String s) {
        ArrayDeque<Object> stk = new ArrayDeque<>();
        // Object '[', ']', Integer, Character;
        s = "1[" + s + "]";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int temp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = 10 * temp + s.charAt(++i) - '0';
                }
                stk.add(temp);
            } else if (s.charAt(i) == '[') {
                stk.add('[');
            } else if (s.charAt(i) == ']') {
                List<Object> dq = new ArrayList<>();
                while (!stk.peekLast().equals('[')){
                    dq.add(stk.pollLast());
                }
                String str = reverse(dq);
                stk.pollLast();
                merge(str, stk);
            } else {
                stk.add(s.charAt(i));
            }
        }
        return (String) stk.poll();
    }

    private String reverse(List<Object> dq) {
        int i = 0, j = dq.size() - 1;
        while (i <= j) {
            Object tmp = dq.get(i);
            dq.set(i, dq.get(j));
            dq.set(j, tmp);
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (Object o : dq) sb.append(o);
        return sb.toString();
    }
    
    private void merge(String str, ArrayDeque<Object> stk) {
        if (!stk.isEmpty()) {
            int number = (int) stk.pollLast();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number; i++) {
                sb.append(str);
            }
            stk.add(sb.toString());
        }
    }
}
