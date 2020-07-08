//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 198 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> set = new HashMap<>();//去重 通过标记integer看是否重复取到
        ArrayList<Integer> list = new ArrayList<>();//记录答案
        int value;

        for (int i = 0; i < nums1.length; i++) {
//            if (!set.containsKey(nums1[i])) {//初始化放入
            set.put(nums1[i], 0);//放入数字 未取出
//            }
        }

        for (int i = 0; i < nums2.length; i++) {
            //如果优化的可以写的简单点 用remove 就不用判断value的值 不可能会重复判断键值了！！ 所以不写了
            if (set.containsKey(nums2[i])) {//判断有没有该键值 很重要。

                value = set.get(nums2[i]);//取出键值
                if (value == 0) {//第一次
                    set.put(nums2[i], value + 1);
                    list.add(nums2[i]);//存入
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
