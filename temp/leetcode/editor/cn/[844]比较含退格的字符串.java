//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 134 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int k = 0, l = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '#') {
                s[k++] = s[i];
            } else {
                k--;
                if (k < 0) k = 0;//防止#个数大于字符个数或者 str头部为#
            }
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i] != '#') {
                t[l++] = t[i];
            } else {
                l--;
                if (l < 0) l = 0;//防止#个数大于字符个数或者 str头部为#
            }
        }
        // char[] char数组转换字符串
        //
        //注意 substring 的边界是[a,b) 不包括b 所以没必要减去1 导致我wa了一次
        return new String(s).substring(0, k).equals(new String(t).substring(0, l));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 11:31	info
 * 解答成功:
 * 执行耗时:1 ms,击败了96.90% 的Java用户
 * 内存消耗:38.2 MB,击败了33.33% 的Java用户
 */