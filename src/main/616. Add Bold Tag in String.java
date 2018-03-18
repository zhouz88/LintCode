class Solution {
    public String addBoldTag(String s, String[] dict) {
        int[] array = new int[s.length()];
        //range addition
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < dict.length; j++) {
                if (s.startsWith(dict[j], i)) {
                    array[i] += 1;
                    if (i + dict[j].length() < s.length()) {
                        array[i + dict[j].length()] -= 1;
                    }
                }
            }
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (array[i] > 0) {
                sb.append(s.charAt(i));
                cnt++;
            } else {
                if (cnt > 0) {
                    sb.insert(sb.length() - cnt,"<b>");
                    sb.append("</b>");
                }
                sb.append(s.charAt(i));
                cnt = 0;
            }
        }

        if (cnt > 0) {
            sb.insert(sb.length() - cnt,"<b>");
            sb.append("</b>");
        }
        return sb.toString();
    }
}
