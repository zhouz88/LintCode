class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int j = i;
            int cnt = words[i].length();
            while (j + 1 < words.length && cnt + words[j + 1].length() + 1 <= maxWidth) {
                cnt += 1 + words[++j].length();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            if (j == i || j == words.length - 1) {
                for (int k = i + 1 ; k <= j; k++) {
                    sb.append(" ");
                    sb.append(words[k]);
                }
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
            } else {
                int n = (maxWidth - cnt)/(j - i);
                int r = (maxWidth - cnt)%(j - i);
                for (int k = i + 1; k <= j; k++) {
                    sb.append(" ");
                    for (int t = 0; t < n; t++) {
                        sb.append(" ");
                    }
                    if (r > 0) { //TWO POINTERS
                        sb.append(" ");
                        r--;
                    }
                    sb.append(words[k]);
                }
            }
            res.add(sb.toString());
            i = j + 1;
        }
        return res;
    }
}
