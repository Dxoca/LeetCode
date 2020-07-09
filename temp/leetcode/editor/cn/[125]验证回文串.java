//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 245 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z') {
                if (b >= 'a' && b <= 'z' || b >= 'A' && b <= 'Z') {
                    a = ((a >= 'A' && a <= 'Z') ? (char) (a + 32) : a);
                    b = ((b >= 'A' && b <= 'Z') ? (char) (b + 32) : b);
                    if (a != b) {
                        return false;
                    } else {
                        i++;
                        j--;
                    }
                } else {
                    j--;
                }
            } else {//不是字母 前移
                i++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
