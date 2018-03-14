class Solution {
    public int lengthLongestPath(String input) {
        String[] t = input.split("\n");
        Stack<String> stk = new Stack<>();
        int max = 0;
        for (int i = 0; i < t.length; i++) {
            int o = cntOft(t[i]);
            if (stk.isEmpty() || cntOft(stk.peek()) < o) {
                stk.add(t[i]);
            } else if (cntOft(stk.peek()) >= o){
                while (!stk.isEmpty() && cntOft(stk.peek()) >= o) {
                    stk.pop();
                }
                stk.add(t[i]);
                if (t[i].contains(".")) {
                    max = Math.max(max, len(stk));
                }
            }
            if (t[i].contains(".")) {
                max = Math.max(max, len(stk));
            }
        }
        return max;
    }

    private int len(Stack<String> stk) {
        int sum = 0;
        for (int i = 0; i < stk.size(); i++) {
            sum += stk.get(i).length() - cntOft(stk.get(i));
        }
        return sum + stk.size() - 1;
    }

    private int cntOft(String t) {
        return t.lastIndexOf("\t") + 1;
    }
}
