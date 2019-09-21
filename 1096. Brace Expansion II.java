import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> result = new ArrayList<>();
        ArrayDeque<Object> stk = new ArrayDeque<>();
        // HashSet<String>, Character ',' '{'
        expression = "{" + expression + "}";
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '{':
                    stk.add('{');
                    break;
                case '}':
                    HashSet<String> next = new HashSet<>();
                    while (!stk.peekLast().equals('{')) {
                        next.addAll((HashSet) stk.pollLast());
                    }
                    stk.pollLast();
                    mergeBackToStk(next, stk);
                    break;
                case ',':
                    stk.add(',');
                    break;
                default:
                    HashSet<String> set = new HashSet<>();
                    set.add(expression.charAt(i) +"");
                    mergeBackToStk(set, stk);
            }
        }
        return new ArrayList<>(new TreeSet<>((HashSet)stk.poll()));
    }

    private void mergeBackToStk(HashSet<String> set, ArrayDeque<Object> stk) {
        if (!stk.isEmpty()) {
            if ( stk.peekLast() instanceof HashSet) {
                HashSet<String> before = (HashSet) stk.pollLast();
                HashSet<String> next = new HashSet<>();
                for (String k : before) {
                    for (String g : set) {
                        next.add(k + g);
                    }
                }
                stk.add(next);
            } else if (stk.peekLast().equals(',')) {
                stk.pollLast();
                stk.add(set);
            } else {
                stk.add(set);
            }
            return;
        }
        stk.add(set);
    }
}
