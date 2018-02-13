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
//my easy understanding 



class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.indexOf('.') != s.lastIndexOf('.')) {
            return false;
        }
        if (s.indexOf('e') != s.lastIndexOf('e')) {
            return false;
        }
        
        String[] strs;
        if (s.contains("e")) {
            if (s.endsWith("e")) {
                return false;
            }
            strs = s.split("e");
            return check(strs[0], 0) && check(strs[1], 1);
        } else {
            return check(s, 0);a
        }
    }

    private boolean check(String s, int leftOrRight) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        if (s.startsWith("+") || s.startsWith("-")) {
            i++;
        }
        boolean flag = false;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (leftOrRight == 0) continue; 
                return false;
            } else {
                if (Character.isDigit(s.charAt(i))) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return flag;
    }
}
