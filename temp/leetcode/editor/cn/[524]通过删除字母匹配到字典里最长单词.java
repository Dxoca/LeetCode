//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
// 如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。
//
// 示例 1:
//
//
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出:
//"apple"
//
//
// 示例 2:
//
//
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出:
//"a"
//
//
// 说明:
//
//
// 所有输入的字符串只包含小写字母。
// 字典的大小不会超过 1000。
// 所有输入的字符串长度不会超过 1000。
//
// Related Topics 排序 双指针

import java.util.List;

//leetcode submit region begin(Prohibit modification and dletion)
class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";//ans 初始化
        for (String target : d) {//遍历所有单词
            int l1 = longestWord.length(), l2 = target.length();//最长串 和 l2// 目标单词的长度
            //不满足的条件
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {//新单词和单词比较 判断符不符合：单词最长 单词长度相同字典序最小
                continue;//换单词
            }
            //满足条件 求是否存在子串 并返回最长
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    /**
     * 字串判断
     *
     * @param s      长串
     * @param target 短串
     * @return
     */
    private boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i++) == target.charAt(j)) {
                j++;
            }
        }
        return j == target.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
