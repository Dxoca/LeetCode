//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (str[i] != str[j]) {
                return isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1);//分支
            }
        }
        return true;//如果没有分支
    }

    private boolean isPalindrome(char[] str, int i, int j) {
        while (i < j) {
            if (str[i++] != str[j--]) {//注意 j-- 不小心打错饿了
                return false;
            }
        }
        return true;
    }

    public boolean error_validPalindrome(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = s.length() - 1;
        boolean flag = true;
        while (i <= j) {
            if ((str[i] == str[j])) {
                i++;
                j--;
            } else if (flag) { //致命问题 只知道当前这一步 和下一步可以成功 但是后续的能否成功不知道 万一 第一个if的是 后续的不回文 第二个的是回文就糟糕了
                //ebcbb ececabbacec bbcbe   删除 e c都可以 先判断的就可能是死路 所以【在删除之后 重新当做的字符串开始判断】
                if (j - 1 >= i && str[i] == str[j - 1]) {//可以删去
                    i++;
                    j -= 2;
                    flag = false;
                } else if (i + 1 <= j && str[i + 1] == str[j]) {//i删去
                    j--;
                    i += 2;
                    flag = false;
                } else
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
