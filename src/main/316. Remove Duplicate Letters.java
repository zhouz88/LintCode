import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        if ("".equals(s)) {
            return "";
        }
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && counts[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
        
            }
            stack.add(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
