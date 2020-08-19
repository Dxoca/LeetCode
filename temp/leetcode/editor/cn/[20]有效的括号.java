//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1760 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        int a, b, c;
        char t;
        a = b = c = 0;
        for (int i = 0; i < n; i++) {
            t = s.charAt(i);
            //))()((
            if (t == '(') a++;
            else if (t == ')') a--;
            else if (t == '[') b++;
            else if (t == ']') b--;
            else if (t == '{') c++;
            else if (t == '}') c--;
            if (a < 0 || b < 0 || c < 0) return false;
        }
        if (a == 0 && b ==0 && c == 0) return true;
        else return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
