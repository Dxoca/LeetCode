//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 153 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 前偶数后奇数 双指针
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (!isEven(A[i]) && isEven(A[j])) {//左右都不符合的时候交换
                swap(A, i++, j--);//并移动指针
            }
            if (isEven(A[i])) i++;//左偶符合
            if (!isEven(A[j])) j--;//右奇符合
        }
        return A;
    }

    /**
     * 交换数据
     *
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 是否偶数
     *
     * @param i
     * @return
     */
    private boolean isEven(int i) {
        return i % 2 == 0 ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
