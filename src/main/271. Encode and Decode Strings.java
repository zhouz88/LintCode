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
