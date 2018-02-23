class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        update(ret, s, new StringBuilder(), 0, 0);
        return ret;
    }
    //201.2.1.0 right  but 201.01.111.1 worng
    private void update(List<String> ret, String s, StringBuilder sb, int start, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && start == s.length()) {
            sb.deleteCharAt(sb.length() - 1);//good
            ret.add(sb.toString());
            return;
        }

        int tmp = 0, i;
        int len = sb.length();

        for (i = start; i < Math.min(s.length(), i + 3); i++) {
            if (i > start && s.charAt(start) == '0') break;// good 
            tmp = 10 * tmp +  s.charAt(i) - '0';
            if (tmp <= 255) {
                sb.append(tmp);
                sb.append('.');
                update(ret, s, sb, i + 1, count + 1);
                sb.setLength(len);
            } else {
                break;
            }
        }
    }
}
