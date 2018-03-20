class Solution {
    public String boldWords(String[] words, String S) {
        int[] array = new int[S.length()];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= S.length() - words[i].length();) {
                int idx = S.indexOf(words[i], j);
                if (idx != -1) {
                    // int idx = S.indexOf(words[i], j);
                    array[idx]++;
                    if (idx + words[i].length() < S.length()) {
                        array[idx + words[i].length()]--;
                    }
                    j = idx + 1;
                } else {
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (array[i] > 0) {
                sb.append(S.charAt(i));
                cnt++;
            } else {
                if (cnt > 0) {
                    sb.insert(sb.length() - cnt, "<b>");
                    sb.append("</b>");
                }
                sb.append(S.charAt(i));
                cnt = 0;
            }
        }
        if (cnt > 0) {
            sb.insert(sb.length() - cnt, "<b>");
            sb.append("</b>");
        }
        return sb.toString();
    }
}
