import java.util.ArrayList;
import java.util.List;

class Solution{//11ms
    public List<String> findRepeatedDnaSequences(String s){
        List<String> ret = new ArrayList<>();
        int mask = 0xfffff;
        
        byte[] map = new byte[1 << 20];
        int[] f = new int[256];
        f['A'] = 0b00;
        f['T'] = 0b01;
        f['C'] = 0b10;
        f['G'] = 0b11;
        int val = 0;
        
        for (int i = 0; i < s.length(); i++) {
            val = (mask & (val << 2) )| f[s.charAt(i)];
            if (i >= 9) {
                if (map[val] == 1) {
                    ret.add(s.substring(i - 9, i + 1));
                    map[val] = 2;
                } else if (map[val] == 0) {
                    map[val]++;
                } else {
                    continue;
                }
            }
        } 
        
        return ret;
    }
}
