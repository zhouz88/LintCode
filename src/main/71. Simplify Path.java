import sun.swing.SwingUtilities2;

class Solution {
    public String simplifyPath(String path) {
        path = path + "/";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = path.length() - 1; i >= 0;) {
            int j = i;
            for (;j - 1 >= 0 && path.charAt(j - 1) == '/'; j--) ;
            int k = j;
            for (;k - 1 >= 0 && path.charAt(k - 1) != '/'; k--) ;
            k--;
            if (k < 0) {
                break;
            }
            String tmp = path.substring(k + 1, j);
            switch (tmp) {
                case "..":
                    cnt++;
                    break;
                case ".":
                    break;
                default:
                    if (cnt == 0) {
                        sb.insert(0, "/" + tmp);
                    } else {
                        cnt--;
                    }
                    break;
            }
            i = k;
        }
        return sb.toString().equals("") ? "/" :  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    }
}
