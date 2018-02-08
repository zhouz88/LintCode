class Solution {
    public boolean isNumber(String s) {
        return s.matches("\\s*[+-]?(\\d+|\\d+\\.|\\d+\\.\\d+|\\.\\d+)(e[+-]?\\d+)?\\s*");
    }
}

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return false;

        boolean numberSeen = false,
                pointSeen = false,
                eSeen = false,
                numberAfterESeen = true;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9){
                numberSeen = true;
                numberAfterESeen = true;
            }else if (c == 'e'){
                if (!numberSeen || eSeen) return false;
                eSeen = true;
                numberAfterESeen = false;
            }else if (c == '.'){
                if (pointSeen || eSeen) return false;
                pointSeen = true;
            }else if (c == '+' || c == '-'){
                if (i != 0 && s.charAt(i-1) != 'e') return false;
            }else{
                return false;
            }
        }

        return numberSeen && numberAfterESeen;
    }
}
