class Solution {
    public String validIPAddress(String IP) {
       if (IP.contains(".")) {
           return checkIPv4(IP);
       } else {
           return checkIPv6(IP);
       }
    }

    private String checkIPv6(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == ':') cnt++;
        }
        if (cnt != 7) {
            return "Neither";
        }
        String[] s = IP.split(":");
        if (s.length != 8) {
            return "Neither";
        }
        String n = "0123456789abcdefABCEDF";
        for (String k : s) {
            if (k.length() > 4 || k.length() == 0) {
                return "Neither";
            }
            for (char ch:k.toCharArray()) {
                if (n.indexOf(ch+"") == -1) {
                    return "Neither";
                }
            }
        }

        return "IPv6";
    }

    private String checkIPv4(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.') {
                cnt++;
            }
        }
        if (cnt != 3) {
            return "Neither";
        }
        String[] s = IP.split("\\.");
        if (s.length != 4) {
            return "Neither";
        }
        for (String k : s) {
            int numberOfDigit = 0;
            if (k.startsWith("0") && k.length() != 1) {
                return "Neither";
            }
            if (k.length() > 3 || k.length() == 0) {
                return "Neither";
            }
            for (char ch : k.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(k) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
}
