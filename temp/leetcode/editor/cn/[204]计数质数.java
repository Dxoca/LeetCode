//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 579 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        boolean[] t = new boolean[n + 1];
        int count = 0;
        if (n <= 2) return 0;
        for (int i = 2; i < n; i++) {
            if (!t[i])
                count++;
            for (int j = i + i; j < n; j += i) {
                t[j] = true;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
