class StringIterator {
    private String cs;
    private int charId = -1;
    private char ch = ' ';
    private int cnt = 0;

    public StringIterator(String compressedString) {
        this.cs = compressedString;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        cnt--;
        return ch;
    }

    public boolean hasNext() {
        if (cnt > 0) {
            return true;
        } else {
            charId++;

            while (charId < cs.length() && Character.isDigit(cs.charAt(charId))) {
                charId++;
            }
            if (charId == cs.length()) {
                return false;
            }
            ch = cs.charAt(charId);
            int j = charId + 1;
            cnt = cs.charAt(j) - '0';//bug1 cnt should not has "int cnt"
            while (j + 1 < cs.length() && Character.isDigit(cs.charAt(j + 1))) {
                cnt = cnt * 10 + cs.charAt(++j) - '0';
            }
            return true;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
