/*471. Encode String with Shortest Length
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a non-empty string, encode the string such that its encoded length is the shortest.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.

Note:
k will be a positive integer and encoded string will not be empty or have extra space.
You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.
Example 1:

Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
Example 2:

Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
Example 3:

Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
Example 4:

Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
Example 5:

Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
*/
public class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        //initital condition
        int i, j , k;
        for (i = 0; i < s.length(); i++) {
            dp[i][i] = s.charAt(i) + "";
        }
        
        //next
        for (int len = 1; len <= n - 1; len++) {
            for (i = 0; i < n; i++) {
                j = Math.min(i + len, n - 1);//bug 2
                String cur = dp[i][i];
                
                for (k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];
                    if (cur.length() == 1) {
                        cur = left + right;
                    } else if (cur.length() > left.length() + right.length()) {
                        cur = left + right;
                    }
                }
                
                String total = s.substring(i, j +  1);//bug3
                int idx = (total + total).indexOf(total, 1);
                if (idx > 0 && idx < total.length()) {//bug 1
                    int f = total.length()/idx;
                    String newString = f + "[" + dp[i][i + idx - 1] + "]";
                    if (newString.length() <= cur.length()) {
                        cur = newString;
                    }
                }
               
                dp[i][j] = cur;
            }
        }
        return dp[0][n - 1];
    }
}
