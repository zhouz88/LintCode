class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty() || (long)stack.peek()*(long)a[i] > 0) {
                stack.add(a[i]);
            } else if (stack.peek() > 0 && a[i] < 0){
                int tmp = stack.pop();
                if (tmp + a[i] > 0) {
                    stack.add(tmp);
                } else if (tmp + a[i] < 0) {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + a[i] < 0) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + a[i] == 0) {
                        stack.pop();
                        continue;
                    }
                    if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + a[i] > 0) {
                       continue;
                    }
                    if (stack.isEmpty() || !stack.isEmpty() && stack.peek() < 0 ) {
                       stack.add(a[i]);
                    }
                } 
            } else {
                stack.add(a[i]);
            }
        }
        int[] ret = new int[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[ret.length - 1 - i] = stack.pop();
        }
        return ret;
    }
}
