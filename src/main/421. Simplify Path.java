import java.util.Stack;

public class Solution {
    /*
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        String[] paths  = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : paths) {
            switch(dir) {
                case "":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                case "." :
                    break;
                default:
                    stack.add(dir);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return !sb.toString().equals("") ? sb.toString() : "/";
    }
}
