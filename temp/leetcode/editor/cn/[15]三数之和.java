//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();//创建答案数组列表
        if (nums == null || nums.length < 3) return ans;// 特判断  空 或 少于三个元素
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;// i 去重
            int l = i + 1, r = nums.length - 1;//i l r 三个指针 i固定 移动 lr
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) r--;//sum太大了 最右边的最大的 缩小
                else if (sum < 0) l++;//太小了 最左边的最小增大
                else {//sum==0
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));//加入的答案中
                    while (l < r && nums[l] == nums[l + 1]) l++;// l去重
                    while (l < r && nums[r] == nums[r - 1]) r--;// r 去重
                    //移动到不重复的位置
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
