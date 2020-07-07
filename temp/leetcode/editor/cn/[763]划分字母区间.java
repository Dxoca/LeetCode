//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
//
//
// 示例 1：
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//
//
//
// 提示：
//
//
// S的长度在[1, 500]之间。
// S只包含小写字母 'a' 到 'z' 。
//
// Related Topics 贪心算法 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        char[] str = S.toCharArray();
        int[] maxIndex = new int[27];//26个字母 桶
        for (int i = 0; i < str.length; i++) {
            maxIndex[str[i] - 'a'] = Math.max(maxIndex[str[i] - 'a'], i);//字母的最大位置
        }
        int i = 0;
        while (i < str.length) {
            int cur = maxIndex[str[i] - 'a'];//获取当前字母的最大索引
            for (int j = i + 1; j < cur; j++) {//扫描当前串的最大边界
                cur = Math.max(cur, maxIndex[str[j] - 'a']);
            }
            ans.add(cur - i + 1);//计算字段长度
            i = cur + 1;//更新起点 如果最后一次是 cur
//            if (str[i] == str[j]) {
//                for (int k = i; k < j; k++) {
//                    j = Math.max(maxIndex[str[k] - 'a'], j);//单词的最大位置大于 j
//                }
//                ans.add(j - i + 1);
//            } else {
//                j--;
//            }
//            i = j + 1;
//            j = str.length - 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
