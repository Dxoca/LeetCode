//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
//input 4
//1 1 1 1 1
//1 2 1
//1 1 2
//2 1 1
//2 2

/**
 * input 5
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 1 2 1
 * 1 2 1 1
 * 2 1 1 1
 * 1 2 2
 * 2 1 1
 * 2 2 1
 */
// Related Topics 动态规划 
// 👍 1157 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {
        /**
         * 从子问题入手，解决原问题，分两种做法：自顶向下和自底向上
         * 前者对应递归，借助了函数调用自己实现，是程序解决问题的方式，它不会记忆解
         * 后者对应DP，利用迭代将结果存在数组里，从数组0位开始顺序往后计算
         * 递归的缺点在于包含重复的子问题，DP 的效率更高
         */
        int[] ans = new int[100];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        for (int i = 4; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
        //递归的复杂度太高
//        if (n >= 2) return climbStairs(n - 1) + climbStairs(n - 2);
//        else return 1;
//        return n >= 2 ? (climbStairs(n - 1) + climbStairs(n - 2)) : 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
