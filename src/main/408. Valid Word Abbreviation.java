class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int sum = 0;
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) ==  abbr.charAt(j)) {
                i++;
                j++;
            } else if (Character.isDigit(abbr.charAt(j))) {
                long tmp = abbr.charAt(j) - '0';
                if (tmp == 0) {
                    return false;
                }
                while (j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))) {
                    tmp = 10 * tmp + (long) (abbr.charAt(++j) - '0');
                }
                i += tmp;
                j++;
            } else if (word.charAt(i) !=  abbr.charAt(j)) {
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
