import java.util.HashMap;
import java.util.Map;

class Solution {
    public double soupServings(int N) {
        if (N >= 10000) return 1.0;
        return dfs(N, N);
    }

    Map<String, Double> map = new HashMap<>();

    private double dfs(double a, double b) {
        if (b <= 0 && a <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1.0;
        } else if (b <= 0) {
            return 0;
        }
        String tmp = a + " " + b;
        if (map.containsKey(tmp)) {
            return map.get(tmp);
        }
        double total = 0;
        total += 0.25 * dfs(a - 100, b);
        total += 0.25 * dfs(a - 50, b - 50);
        total += 0.25 * dfs(a - 25, b - 75);
        total += 0.25 * dfs(a - 75, b - 25);
        map.put(tmp, total);
        return total;
    }
    /*
    Serve 100 ml of soup A and 0 ml of soup B
Serve 75 ml of soup A and 25 ml of soup B
Serve 50 ml of soup A and 50 ml of soup B
Serve 25 ml of soup A and 75 ml of soup B
When we serve some soup, we give it to some
     */
}
