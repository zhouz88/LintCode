class Solution {
    public boolean isNumber(String s) {
        return s.matches("\\s*[+-]?(\\d+|\\d+\\.|\\d+\\.\\d+|\\.\\d+)(e[+-]?\\d+)?\\s*");
    }
}

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
            return check(s, 0);
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
