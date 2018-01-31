import java.util.HashMap;
import java.util.Map;

public class Codec{
    private static int GLABAL_ID = 0;
    private static String REFERENCE_STRING;
    private Map<String, Integer> string_id = new HashMap<>();
    private Map<Integer, String> id_string = new HashMap<>();

    Codec() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            sb.append(i);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            sb.append(ch);
        }
        REFERENCE_STRING = sb.toString();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
         if(string_id.containsKey(longUrl)) {
             int id = string_id.get(longUrl);
             return "http://tinyurl.com/" + F(id);
         } else {
             GLABAL_ID++;
             string_id.put(longUrl, GLABAL_ID);
             id_string.put(GLABAL_ID, longUrl);
             return "http://tinyurl.com/" + F(GLABAL_ID);
         }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       String code = shortUrl.substring("http://tinyurl.com/".length());
       int id = f(code);
       return id_string.get(id);
    }

    private int f(String code) {
        int ret = 0;
        for (char ch : code.toCharArray()) {
            ret = ret*62 + REFERENCE_STRING.indexOf(ch);
        }
        return ret;
    }

    private String F(int id) {
        String ret = "";
        while (id > 0) {
            int m = id%62;
            char tmp = REFERENCE_STRING.charAt(m);
            ret = tmp + ret;
            id /= 62;
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
