//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次
//而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 双指针 字符串 
// 👍 9 👎 0

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {

        int min = 0xfffff, a = -1, b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;//第一个单词出现的位置
            } else if (words[i].equals(word2)) {
                b = i;//第二个单词出现的位置
            }
            //排除初始化数据
            if (a == -1 || b == -1) continue;
            //计算最小差值
            if (Math.abs(a - b) < min) min = Math.abs(a - b);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
