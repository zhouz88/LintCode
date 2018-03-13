class SnakeGame {
    private LinkedList<int[]> q;
    private Set<Integer> set;
    private int m;
    private int n;
    private int[][] food;
    private int idx;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.q = new LinkedList<>();
        n = width;
        m = height;

        this.food = food;
        idx = 0;

        q.addLast(new int[]{0, 0});
        set = new HashSet<>();
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = 0, y = 0;
        int[] head;
        switch(direction) {
            case "U" :
                head = q.peekLast();
                x = head[0] - 1;
                y = head[1];
                if (x<0) {
                    return -1;
                }
                break;
            case "L" :
                head = q.peekLast();
                x = head[0];
                y = head[1] - 1;
                if (y<0) {
                    return -1;
                }
                break;
            case "R" :
                head = q.peekLast(); 
                x = head[0];
                y = head[1] + 1;
                if (y>=n) {
                    return -1;
                }
                break;
            case "D" :
                head = q.peekLast();         
                x = head[0] + 1;
                y = head[1];
                if (x>=m) {
                    return -1;
                }
                break;
        }

        if (idx < food.length && food[idx][0] == x && food[idx][1] == y) { //eat food
            q.add(new int[]{x, y});
            set.add(x*n + y);
            idx++;
            return q.size() - 1;
        }

        int[] out = q.pollFirst();//get head out
        set.remove(out[0]*n + out[1]);
        
        if (set.contains(x*n+y)) {//if bites its body;
            return -1;
        }
        
        set.add(x*n+y);//add head
        q.addLast(new int[]{x, y});//add new head;

        return q.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
