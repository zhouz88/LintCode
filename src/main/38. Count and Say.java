class Solution {
    public String countAndSay(int n) {
        String start = "1";
        while (n != 1) {
            n--;
            start = getStart(start);
        }
        return start;
    }

    private String getStart(String start) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < start.length(); i++) {
            if (start.charAt(i) == start.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(start.charAt(i - 1));
                cnt = 1;
            }
        }
        if (cnt != 0) {
            sb.append(cnt);
            sb.append(start.charAt(start.length() - 1));
        }
        return sb.toString();
    }
}
