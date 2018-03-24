class Solution {
    public boolean isValidSerialization(String preorder) {
       int diff = 1;
       String[] t = preorder.split(",");
       for (String k : t) {
           diff--; //minus indegree father;
           if (diff < 0) return false;
           if (!k.equals("#")) {
               diff += 2;
           }
       }
       return diff == 0;
    }
}
