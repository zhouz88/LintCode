168. Excel Sheet Column Titleclass 
Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0,(char)('A'+n%26));
            n = n/26;
        }
        return sb.toString();
    }
}

class Solution {
    public int titleToNumber(String s) {
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp = 26 * tmp + (s.charAt(i) - 'A' + 1);
        }
        return tmp;
    }
}
