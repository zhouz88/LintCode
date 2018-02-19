import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<String,Long>  longUrlIdMap= new HashMap<>();
    private Map<Long, String>  idLongUrlMap= new HashMap<>();
    private static long NUBMER = 0;
    private static String string;

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
        string = sb.toString();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrlIdMap.containsKey(longUrl)) {
            return "http://tinyurl.com/" + numberToCode(longUrlIdMap.get(longUrl));
        }
        
        NUBMER++;
        longUrlIdMap.put(longUrl, NUBMER);
        idLongUrlMap.put(NUBMER, longUrl);
        return "http://tinyurl.com/" + numberToCode(NUBMER);
    }
    
    private String numberToCode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            long idx = num%62;
            sb.insert(0, string.charAt((int)(idx)));
            num /= 62;
        }
        return sb.toString();
    }

    private long codeToNumber(String s) {
        String k = s.replace("http://tinyurl.com/", "");
        long tmp = 0;
        for (int i = 0; i < k.length(); i++) {
            tmp = 62 * tmp + string.indexOf(k.charAt(i));
        }
        return tmp;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long res = codeToNumber(shortUrl);
        return idLongUrlMap.get(res);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
