168. Excel Sheet Column Titleclass 
Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0,(char)('A'+n%26));
            n = n/26;
        }
        return sb.toString();
    }
}
