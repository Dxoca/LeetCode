//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1532 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i + 1]) {
                if (i == nums.length - 2) {
                    return nums[i + 1];
                }
                continue;
            } else
                break;
        }
        return nums[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
