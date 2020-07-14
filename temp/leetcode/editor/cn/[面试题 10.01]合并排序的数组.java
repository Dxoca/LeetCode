//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 61 👎 0

import java.awt.image.renderable.RenderableImage;

/**
 * 10:58	info
 * 		解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:40 MB,击败了100.00% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution10_01 {
    //和 88  一样
    public void merge(int[] A, int m, int[] B, int n) {
        int resultIndex = A.length - 1;//最大索引位置 也就是 m+n-1
        int aIndex = m - 1;//a数组最后
        int bIndex = n - 1;
        while (aIndex >= 0 || bIndex >= 0) {//只要有一个还在范围内
            if (aIndex < 0) {//其中的b还在范围内 a超出
                A[resultIndex--] = B[bIndex--]; //存入b的全部数据
            } else if (bIndex < 0) {//a在范围内 b超出
                A[resultIndex--] = A[aIndex--];//存入a的全部数据
            } else if (A[aIndex] > B[bIndex]) {//a大于b 放入a
                A[resultIndex--] = A[aIndex--];
            } else {
                A[resultIndex--] = B[bIndex--];
            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
