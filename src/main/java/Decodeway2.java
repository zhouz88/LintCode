/*
676. Decode Ways II 

 Description
 Notes
 Testcase
 Judge
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character *, which can be treated as one of the numbers from 1 to 9.
Given the encoded message containing digits and the character *, return the total number of ways to decode it.
Also, since the answer may be very large, you should return the output mod 10^9 + 7.

 Notice

The length of the input string will fit in range [1, 10^5].
The input string will only contain the character * and digits 0 - 9.
Have you met this question in a real interview? Yes
Example
Given s = "*"
return 9 // The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

Given s = "1*"
return 18




*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        final int mod = 1000000007;
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = 0;
            if (s.charAt(i - 1) == '*') {
                f[i] = (int)((f[i] + 9L * f[i - 1]) % mod);
                if (i >= 2) {
                    if (s.charAt(i - 2) == '*') {
                        f[i] = (int)((f[i] + 15L * f[i - 2]) % mod);
                    }
                    else if (s.charAt(i - 2) == '1') {
                        f[i] = (int)((f[i] + 9L * f[i - 2]) % mod);
                    }
                    else if (s.charAt(i - 2) == '2') {
                        f[i] = (int)((f[i] + 6L * f[i - 2]) % mod);
                    }
                }
            }
            else {
                if (s.charAt(i - 1) != '0') {
                    f[i] = (f[i] + f[i - 1]) % mod;
                }
                if (i >= 2) {
                    if (s.charAt(i - 2) == '*'){
                        if (s.charAt(i - 1) <= '6') {
                            f[i] = (int)((f[i] + 2L * f[i - 2]) % mod);
                        }
                        else {
                            f[i] = (f[i] + f[i - 2]) % mod;
                        }
                    }
                    else {
                        int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                        if (twoDigits >= 10 && twoDigits <= 26) {
                            f[i] = (f[i] + f[i - 2]) % mod;
                        }
                    }
                }
            }
        }
        
        return f[n];
    }
}
