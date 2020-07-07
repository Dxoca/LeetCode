//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        if (nums == null || nums.length < 4) {//特判
            return ans;
        }
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length - 3; i++) {
//            if (nums[i] > target) break; //大于目标数
//            if (i > 0 && nums[i] == nums[i - 1]) continue;//i去重

            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] > target) break;
//                if (j > i && nums[j] == nums[j - 1]) continue;//j去重
                int l = j + 1, r = nums.length - 1;

                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) r--;//太大了 大的减少
                    else if (sum < target) l++;
                    else {
                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
