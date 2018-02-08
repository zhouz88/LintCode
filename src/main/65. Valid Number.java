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

//
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int i = 0;
        if (i == s.length()) {
            return false;
        }

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        if (i == s.length()) {
            return false;
        }
        boolean containsNumber = false;
        boolean containsAfterENumber = false;
        if (s.contains(".")) {
            int j = s.indexOf(".");
            while (i < j & isD(s.charAt(i))) {
                i++;
                containsNumber = true;
            }
            if (i != j) {
                return false;
            }
            if (s.contains("e")) {
                i++;
                int k = s.indexOf("e");
                while (i < k && isD(s.charAt(i))) {
                    i++;
                    containsNumber = true;
                }
                if (i != k || !containsNumber) {
                    return false;
                }
                i++;
                if (i == s.length()) {
                    return false;
                }
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    i++;
                }
                while (i < s.length() && isD(s.charAt(i))) {
                    i++;
                    containsAfterENumber = true;
                }
                return s.length() == i && containsAfterENumber;
            } else {
                i++;
                while (i < s.length() && isD(s.charAt(i))) {
                    i++;
                    containsNumber = true;
                }
                return i == s.length() && containsNumber;
            }
        } else {
            if (s.contains("e")) {
                int k = s.indexOf("e");
                while (i < k && isD(s.charAt(i))) {
                    i++;
                    containsNumber = true;
                }
                if (i != k || !containsNumber) {
                    return false;
                }
                i++;
                if (i == s.length()) {
                    return false;
                }
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    i++;
                }
                while (i < s.length() && isD(s.charAt(i))) {
                    i++;
                    containsAfterENumber = true;
                }
                return s.length() == i && containsAfterENumber;
            } else {
                while (i < s.length() && isD(s.charAt(i))) {
                    i++;
                    containsNumber = true;
                }
                return i == s.length() && containsNumber;
            }
        }


    }

    private boolean isD(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
