//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。 
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
//
// 示例 1: 
//
// 
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释: 
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
// 
//
// 注意: 
//
// 
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。 
// 1 <= k <= 3500 
// -105 <= 元素的值 <= 105 
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。 
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 152 👎 0

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] p = new int[nums.size()];//p个指针

        int[] ans = new int[]{0, (int) 1e8};//答案

        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minp = 0;//记录最小指针在那个列

            for (int i = 0; i < p.length; i++) {
                int num = nums.get(i).get(p[i]);//p[i] 默认为0 每一行的
                if (num < min) {
                    min = num;
                    minp = i;//记录最小的行
                }
                if (num > max) {
                    max = num;
                }
            }

            //up ans
            if (max - min < ans[1] - ans[0]) {
                ans[1] = max;
                ans[0] = min;
            }
            //更新指针 扫描到头 就gg
            p[minp]++;
            if (p[minp] >= nums.get(minp).size()) {
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
