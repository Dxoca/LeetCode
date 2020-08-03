//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串 
// 👍 211 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        //字符串加法、链表加法以及二进制加法之类的都可以这么写
//2020年8月3日 11:05:15
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        //carry进位
        while (i >= 0 || j >= 0 || carry != 0) {//只要j或者i还没加完 或者存在进位 一直加
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);//加入本位留下进位
            carry /= 10;
        }
        return sb.reverse().toString();//翻转
        //2020年8月3日 11:14:58

    }
}
//leetcode submit region end(Prohibit modification and deletion)
