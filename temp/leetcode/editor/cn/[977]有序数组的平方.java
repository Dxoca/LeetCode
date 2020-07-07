//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
class Solution977 {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int i = 0, j = A.length - 1;
        int k = j;//B索引
        while (i <= j) {//指正重合 结束
            if (Math.abs(A[i]) > Math.abs(A[j])) {//比较绝对值 最大的在最后面
                B[k--] = A[i] * A[i];
                i++;
            } else {
                B[k--] = A[j] * A[j];
                j--;
            }
        }
        return B;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
