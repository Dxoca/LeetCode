//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 289 👎 0

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            if (map.containsKey(a)) map.put(a, false);
            else map.put(a, true);
        }
        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i))) return i;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
