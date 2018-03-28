import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String K : strs) {
            K = K.replace("/", "//");
            sb.append(" / ");
            sb.append(K);
            sb.append(" / ");
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        String[] t = s.split(" / ");
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(" / ", i)) {
                int idx = s.indexOf(" / ", i + 1);
                String g = (s.substring(i + 3, idx)).replace("//", "/");
                res.add(g);
                i = idx + 2;
            }
        }
        return res;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String cur = strs.get(i);
            sb.append(" / ");
            String change = change(cur);
            sb.append(change);
            sb.append(" / ");
        }
        return sb.toString();
    }

    private String change(String cur) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == '/') {
                sb.append("//");
            } else {
                sb.append(cur.charAt(i));
            }
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if ("".equals(s)) {
            return res;
        }
        for (int i = 0; i < s.length();) {
            if (s.startsWith(" / ", i)) {
                int end = s.indexOf(" / ", i + 1);
                String cur = s.substring(i + 3, end);
                res.add(recover(cur));
                i = end + 3;
            }
        }
        return res;
    }
    

    private String recover(String cur) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur.length();) {
            if (i + 1 < cur.length() && cur.charAt(i) == '/' && cur.charAt(i + 1) == '/') {
                sb.append('/');
                i += 2;
            } else {
                sb.append(cur.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
