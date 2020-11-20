//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 1996 👎 0

import static java.lang.Math.abs;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        int ans = 0;
        int f = Math.abs(x);
        //125
        while (f > 0) {
            ans += f % 10;//5 2 1 520
            f /= 10;
            ans *= 10;
        }
        ans /= 10;
        return ans * sign > 230 || ans * sign < -231 ? 0 : ans * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
