
public class Solution {
    /*
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        int[] number1 = new int[num1.length()];
        int[] number2 = new int[num2.length()];
        int i, j;
        
        for (i = 0; i < num1.length(); i++) {
            number1[i] = num1.charAt(i) - '0';
        }

        for (i = 0; i < num2.length(); i++) {
            number2[i] = num2.charAt(i) - '0';
        }

        int[] ret = new int[221];
        int len = ret.length, l1 = number1.length, l2 = number2.length;
        
        for (i = 0; i < number1.length; i++) {
            for (j = 0; j < number2.length; j++) {
                ret[len - 1 - (l1 - i - 1) - (l2 - j - 1)] += number1[i] * number2[j];
            }
        }
        
        for (i = len - 1; i >= 1; i--) {
            ret[i - 1] += ret[i]/10;
            ret[i] = ret[i]%10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < ret.length; i++) {
            if (ret[i] != 0) {
                break;
            }
        }
        for (; i < ret.length; i++) {
            sb.append(ret[i]);
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
