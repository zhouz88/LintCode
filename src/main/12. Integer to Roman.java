public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        //M 1000 D 500 C 100 L 50 X 10 V 5 I 1
        String[] thouand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D" ,"DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thouand[(n/1000)%10] + hundred[(n/100)%10] + ten[(n/10)%10] + one[n%10];
    }
}
