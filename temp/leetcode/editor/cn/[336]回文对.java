//给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 示例 1: 
//
// 输入: ["abcd","dcba","lls","s","sssll"]
//输出: [[0,1],[1,0],[3,2],[2,4]] 
//解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2: 
//
// 输入: ["bat","tab","cat"]
//输出: [[0,1],[1,0]] 
//解释: 可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串 
// 👍 100 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //js 可以ac
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                sb = new StringBuilder(words[i] + words[j]);
                if (isPalindrome(sb)) {
                    ans.add(Arrays.asList(i, j));
                }
                sb = new StringBuilder(words[j] + words[i]);
//                sb.append(words[j] + words[i]);
                if (isPalindrome(sb)) {
                    ans.add(Arrays.asList(j, i));
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(StringBuilder sb) {
        int i = 0, j = sb.length() - 1;
        while (i <= j) {
            if (sb.charAt(i++) != sb.charAt(j--)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
