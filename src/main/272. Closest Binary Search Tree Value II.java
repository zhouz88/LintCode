class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> left = new Stack<>();    //all value smaller than target, getPre
        Stack<TreeNode> right = new Stack<>();   //all value larger than or equal to target
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < target){
                left.push(cur);     
                cur = cur.right;
            }else{
                right.push(cur);
                cur = cur.left;
            }
        }       
        while(k-- > 0){
            if(!left.isEmpty() && !right.isEmpty()){
                if(Math.abs((double)left.peek().val - target) < Math.abs((double)right.peek().val - target)) res.add(getNextLeft(left));
                else res.add(getNextRight(right));
            }else if(!left.isEmpty()) res.add(getNextLeft(left));
            else if(!right.isEmpty()) res.add(getNextRight(right));
        }
        return res;
    }
    
    private int getNextLeft(Stack<TreeNode> left){
        TreeNode top = left.pop();
        int res = top.val;
        TreeNode cur = top.left;
        while(cur != null){
            left.push(cur);
            cur = cur.right;
        }
        return res;
    }
    
    private int getNextRight(Stack<TreeNode> right){
        TreeNode top = right.pop();
        int res = top.val;
        TreeNode cur = top.right;
        while(cur != null){
            right.push(cur);
            cur = cur.left;
        }
        return res;
    }
}
