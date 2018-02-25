class Solution {
    public boolean isStrobogrammatic(String num) {
       int i = 0, j = num.length() - 1;
       while (i < j) {
           switch (num.charAt(i)) {
               case '1':
                   if (num.charAt(j) != '1') {
                       return false;
                   }
                   break;
               case '0':
                   if (num.charAt(j) != '0') {
                       return false;
                   }
                   break;
               case '6':
                   if (num.charAt(j) != '9') {
                       return false;
                   }
                   break;
               case '9':
                   if (num.charAt(j) != '6') {
                       return false;
                   }
                   break;
               case '8':
                   if (num.charAt(j) != '8') {
                       return false;
                   }
                   break;
               default:
                   return false;
           }
           i++;
           j--;
       }
       if (i == j && (num.charAt(i) != '0' && num.charAt(i) != '1' && num.charAt(i) != '8' )) {//bug1
           return false;
       }
       return true;
    }
}
