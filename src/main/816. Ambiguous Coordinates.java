import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            String first = S.substring(0, i);
            String second = S.substring(i);
            //
            if (first.length() == 0 || second.length() == 0) continue;
            if (!first.matches("0[0-9]+") && !second.matches("0[0-9]+")) {
                res.add(add(first, second));
            }
            for (int j = 1; j < first.length(); j++) {
                String a = first.substring(0, j) + "." + first.substring(j);
                if (dotMat(a) && !second.matches("0[0-9]+")) {
                    res.add(add(a, second));
                }
            }
            for (int j = 1; j < second.length(); j++) {
                String a = second.substring(0, j) + "." + second.substring(j);
                if (dotMat(a) && !first.matches("0[0-9]+")) {
                    res.add(add(first, a));
                }
            }
            for (int j = 1; j < first.length(); j++) {
                for (int k = 1; k < second.length(); k++) {
                    String a = first.substring(0, j) + "." + first.substring(j);
                    String b = second.substring(0, k) + "." + second.substring(k);
                    if (dotMat(a) && dotMat(b)) {
                        res.add(add(a, b));
                    }
                }
            }
        }
        return res;
    }

    private boolean dotMat(String a) {
        return !a.matches("0[0-9]+\\.[0-9]*") && !a.matches("[0-9]*\\.([0-9]*)(0+)");
    }

    private String add(String first, String second) {
        return "(" + first + ", " + second + ")";
    }
}
