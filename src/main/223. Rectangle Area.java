class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rec1 = (C - A) * (D - B);
        int rec2 = (G - E) * (H - F);
        int x = Math.max(A, E);
        int y = Math.min(C, G);
        int X = Math.max(B, F);
        int Y = Math.min(H, D);
        
        if (x >= y || X >= Y) {
            return rec1 + rec2;
        }
        
        return rec1 + rec2 - (x - y) * (X - Y);
    }
}
