class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, map[num & 0b1111]);
            num = (num >>> 4);
        }
        System.out.println( -16 >> 1); //区别 移动正数部分16， 最后把正数再变为负数 得到 -8
        System.out.println( -16 >>> 1);//直接移动负数-16的（也就是4的反码+1,)
        return sb.toString();
    }
    
// -1 的 补码（正数的反码 11111111111111111111111111111110+1）为 32个1, 每次 & 1111后得到一个f 
//   >>> 4 无符号移动四位后 （移动补码）得到 00001111
    
    
    //-4 为 0100
}
