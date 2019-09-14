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

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int start = 0, end = 0, len = words[start].length();
        while (start < words.length) {
            len = words[start].length();
            while (hasNextWord(end + 1, len, words, maxWidth)) {
                len += words[++end].length() + 1;
            }
            if (end < words.length - 1) addLine(start, end, words, maxWidth, res, len);
            else addLastLine(start, end, words, maxWidth, res, len);
            start = ++end;
        }
        return res;
    }
    
    private void addLastLine(int start, int end, String[] words, int maxWidth, List<String> res, int len){
        char[] ret = new char[maxWidth];
        Arrays.fill(ret, ' ');
        if (start == end) {
            fillWord(ret, words[start], 0);
            res.add(new String(ret));
            return;
        }
        int idx = 0;
        for (int i = start; i <= end; i++) {
            idx = fillWord(ret, words[i], idx);
            idx ++;
        }
        res.add(new String(ret));
    }
    
    private void addLine(int start, int end, String[] words, int maxWidth, List<String> res, int len) {
        char[] ret = new char[maxWidth];
        Arrays.fill(ret, ' ');
        if (start == end) {
            fillWord(ret, words[start], 0);
            res.add(new String(ret));
            return;
        }
        int m = (maxWidth - len) / (end - start);
        int n = (maxWidth - len) % (end - start);
        int idx = 0;
        for (int i = start; i <= end; i++) {
            idx = fillWord(ret, words[i], idx);
            idx += m + 1;
            if (i - start + 1 <= n) {
                idx++;
            }
        }
        res.add(new String(ret));
    }
    
    private int fillWord(char[] ret, String word, int k) {
        for (int i = 0; i < word.length(); i++) {
            ret[k++] = word.charAt(i);
        }
        return k;
    }
    
    private boolean hasNextWord(int i, int len, String[] words, int maxWidth) {
        if (i >= words.length) return false;
        len += words[i].length() + 1;
        return len <= maxWidth;
    }
}
