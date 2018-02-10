class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int total;
        while (i >= 0 && j >= 0) {
            total = carry + a.charAt(i) - '0' + b.charAt(j) - '0';
            sb.insert(0, total%2);
            carry = total/2;
            i--;//wrong1
            j--;
        }
        while (i >= 0) {
            total = carry + a.charAt(i) - '0';
            sb.insert(0, total%2);
            carry = total/2;
            i--;
        }
        while (j >= 0) {
            total = carry + b.charAt(j) - '0';
            sb.insert(0, total%2);
            carry = total/2;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, 1); //wrong 2
        }
        return sb.toString();
    }
}
