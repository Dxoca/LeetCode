//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。 
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学

//leetcode submit region begin(Prohibit modification and deletion)
class Solution633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);//j的上限
        if (c < 0)
            return false;
        while (i <= j) {//双指针 等号是 同一个数字
            int mul = i * i + j * j;
            if (mul < c) i++;
            else if (mul > c)
                j--;
            else return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
