//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 153 👎 0

import java.util.Arrays;

import static java.lang.Math.max;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length - 1;
        //最后三个数字 或者，最前面俩数字（可能是最小负数乘积为大正数 ）和最后一个数字
        return Math.max(nums[k] * nums[k - 1] * nums[k - 2], nums[0] * nums[1] * nums[k]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
