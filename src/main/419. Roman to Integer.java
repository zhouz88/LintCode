public class Solution {
    /*
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int total;
        char[] sc =  s.toCharArray();
        total = map[sc[0]];                        //0 special
        for (int i = 1; i < s.length(); i++) {
            total += map[sc[i]];
            if (map[sc[i - 1]] < map[sc[i]]) {
                total -= map[sc[i - 1]] * 2;
            }
        }
        return total;
    }
}

         *   *
    *             
*                 *  *
-   -     +   +   +  +                *
                                *     +
                                 -
                                
                                
                                public class Solution {
    /*
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || map[ch] > stack.peek()) {
                stack.add(map[ch]);
            } else if (map[ch] <= stack.peek()) {
                total += stack.pop();
                while (!stack.isEmpty()) {
                    total -= stack.pop();
                }
                stack.add(map[ch]);
            }
        }
        if (!stack.isEmpty()) {
            total += stack.pop();
        }
        while (!stack.isEmpty()) {
            total -= stack.pop();
        }
        return total;
    }
}

//Integer to Roman

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        //M 1000 D 500 C 100 L 50 X 10 V 5 I 1
        String[] qian = {"", "M", "MM", "MMM" };
        String[] bai = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] shi = {"", "X", "XX", "XXX", "XL", "L", "LX" , "LXX", "LXXX", "XC"};
        String[] gewei = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return qian[n/1000] + bai[(n/100)%10] + shi[(n/10)%10] + gewei[n%10];
    }
}

