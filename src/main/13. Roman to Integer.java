class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int[] map = new int[256];
        map['M'] = 1000;
        map['D'] = 500;
        map['C'] = 100;
        map['L'] = 50;
        map['X'] = 10;
        map['V'] = 5;
        map['I'] = 1;
        sum = map[s.charAt(0)];
        int pre = sum;
        for (int i = 1; i < s.length(); i++) {
            int tmp = map[s.charAt(i)];
            sum += tmp;
            if (tmp > pre) {
                sum -= 2*pre;
            }
            pre = tmp;
        }
        return sum;
    }
}
