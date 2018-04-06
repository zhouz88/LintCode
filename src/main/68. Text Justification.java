class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length;) {
            int j = i;
            int total = words[j].length();
            StringBuilder sb = new StringBuilder();
            sb.append(words[j]);
            while (j + 1 < words.length && total + words[j + 1].length() + 1 <= maxWidth) {
                total += 1 + words[++j].length();
            }
            if (j == i || j == words.length - 1) {
                for (int k = i + 1; k <= j; k++) {
                    sb.append(" ");
                    sb.append(words[k]);
                }
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
            } else {
                int n = (maxWidth - total)/(j - i);
                int m = (maxWidth - total)%(j - i);
                for (int k = i + 1; k <= j; k++) {
                    sb.append(" ");
                    for (int z = 0; z < n; z++) {
                        sb.append(" ");
                    }
                    if (m-- > 0) {
                        sb.append(" ");
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
