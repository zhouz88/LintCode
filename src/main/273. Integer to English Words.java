class Solution {

    private static final String[] SINGLEDIGITS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine"};

    private static final String[] LESSTHANTWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen",
       "Eighteen", "Nineteen"};

    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};

    private static final String[] TRIPLEZEROS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
       if (num == 0) {
           return "Zero";
       }
       String res = "";
       int i = 0;

       while (num > 0) {
           if (num % 1000 != 0) {
               res = readHundreds(num%1000) + " " + TRIPLEZEROS[i] + " " + res;
           }
           num /= 1000;
           i++;
       }

       return res.trim();
    }

    private String readHundreds(int k) {
        if (k == 0) {
            return "";
        } else if (k < 10) {
            return SINGLEDIGITS[k];
        } else if (k < 20) {
            return LESSTHANTWENTY[k - 10];
        } else if (k < 100) {
            return (TENS[k/10] + " " + SINGLEDIGITS[k%10]).trim();
        } else {
            return (SINGLEDIGITS[k/100] + " Hundred " +  readHundreds(k%100)).trim();
        }
    }

}
