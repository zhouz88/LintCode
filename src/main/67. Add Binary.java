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
//for
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] res = new int[m + n + 1];
        int i, j;
        int idx = 0;
        int carry = 0;
        
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; idx++, i--, j--) {
            int total = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            res[idx] = total%2;
            carry = total/2;
        }
        
        for (;i >= 0; i--) {
            int total = a.charAt(i) - '0' + carry;
            res[idx++] = total%2;
            carry = total/2;
        }

        for (;j >= 0; j--) {
            int total = b.charAt(j) - '0' + carry;
            res[idx++] = total%2;
            carry = total/2;
        }
        
        if (carry == 1) {
            res[idx++] = 1;
        }
        
        for (i = res.length - 1; i >= 0; i--) {
            if (res[i] == 1) {
                break;
            }
        }
        if (i == -1) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (;i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
