//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。
// Related Topics 双指针 字符串

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution345 {

    //快速判断 一个字符是否是元音字符 加入到 Hash集合中判断 O(1)
    public static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        char a, b;
        while (i <= j) {
            a = s.charAt(i);
            b = s.charAt(j);
            if (!set.contains(a)) {//判断是否在集合中
                result[i++] = a;//不在 保存当前
            } else if (!set.contains(b)) { //i在 看j在不在
                result[j--] = b;
            } else {//俩都在  索引换位置记录
                result[i++] = b;
                result[j--] = a;
            }
        }
        return new String(result);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
