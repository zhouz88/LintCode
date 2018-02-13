class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //corner case
        if (words == null || words.length < 1) {
            return new ArrayList<>();
        }
        
        //general
        List<String> ret = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int total = 0;
        int cnt = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (total + words[i].length() + cnt > maxWidth) { //bug 1 no ()
                StringBuilder sb = new StringBuilder();
                if (cnt == 1) {                          //bug 4 cnt should be only 1
                    sb.append(q.poll());
                    while (sb.length() < maxWidth) {
                        sb.append(' ');
                    }
                    ret.add(sb.toString());
                    cnt = 1;                   //bug 2 forget this line;
                    total = words[i].length() ;
                    q.add(words[i]);
                    continue;
                }
                
                int n = (maxWidth - total)/(cnt - 1);        // cnt == 1
                int m = (maxWidth - total)%(cnt - 1);
                int num = cnt - 1;
                while (num > 0) {
                    sb.append(q.poll());
                    if (m > 0) {
                        for (int j = 0; j < n + 1; j++) {
                            sb.append(' ');
                        }
                        m--;
                    } else {
                         for (int j = 0; j < n; j++) {
                            sb.append(' ');
                        }
                    }
                    num--;
                }
                sb.append(q.poll());
                ret.add(sb.toString());
                cnt = 1;                                 //bug 2 forget this line;
                total = words[i].length() ;
                q.add(words[i]);
            } else {
                total += words[i].length();
                cnt++;
                q.add(words[i]);
            }
        }
        
        //last Line
        StringBuilder builder = new StringBuilder();
        while (q.size() > 1) {
            builder.append(q.poll());
            builder.append(' ');
        }
        builder.append(q.poll());
        while (builder.length() < maxWidth) {           //bug 3 final empty
            builder.append(' ');
        }
        ret.add(builder.toString());
        return ret;
    }
}
