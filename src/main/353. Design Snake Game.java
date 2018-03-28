import java.util.ArrayDeque;
import java.util.HashSet;

class SnakeGame {
    private ArrayDeque<Integer> dq;
    private int[][] food;
    private HashSet<Integer> visited;
    private int currentFood;
    private int n;//width
    private int m; //height;

    public SnakeGame(int width, int height, int[][] food) {
       this.dq = new ArrayDeque<>();
       this.food = food;
       this.visited = new HashSet<>();
       currentFood = 0;
       n = width;
       m = height;
       dq.addLast(0);
    }

    public int move(String direction) {
        int head = dq.peekLast();
        int x = head/n, y = head % n;
        switch (direction) {
            case "U": x--;
                break;
            case "D": x++;
                break;
            case "L": y--;
                break;
            case "R": y++;
                break;
        }
        if (x<0||x>=m||y<0||y>=n) return -1;
        int newNode = x*n+y;

        //newNode is food
        if (currentFood < food.length && food[currentFood][0] == x && food[currentFood][1] == y) {
            dq.addLast(newNode);
            visited.add(newNode);
            currentFood++;
            return dq.size() - 1;
        }

        //newNode not food
        visited.remove(dq.pollFirst());

        if (visited.contains(newNode)) {
            return -1;
        }
        visited.add(newNode);
        dq.add(newNode);
        return dq.size() - 1;
    }
}
