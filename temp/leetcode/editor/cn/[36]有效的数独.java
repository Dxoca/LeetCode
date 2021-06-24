//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 431 👎 0

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[][] setSquare = new HashSet[3][3];
        HashSet<Character>[] setRow = new HashSet[N];//行
        HashSet<Character>[] setCol = new HashSet[N];//列

        for (int i = 0; i < N; i++) {
            setCol[i] = new HashSet<>();
            setRow[i] = new HashSet<>();
            for (int j = 0; j < N; j++) {//初始化
                setSquare[i/3][j/3] = new HashSet<>();
            }
        }
        char key;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                key = board[i][j];
                //0 1 2 ,3 4 5, 6 7 8
                //0 0 0 ，1 1 1 ，2 2 2
                if (key == '.') continue;
                if (setSquare[i / 3][j / 3].contains(key)) {
                    return false;
                } else {
                    setSquare[i / 3][j / 3].add(key);
                }
                if (setRow[i].contains(key)) {
                    return false;
                } else {
                    setRow[i].add(key);
                }
                if (setCol[j].contains(key)) {
                    return false;
                } else {
                    setCol[j].add(key);
                }

            }
        }
        return true;
//        public boolean isValidSudoku(char[][] board) {
//            HashSet<Integer>[] rows = new HashSet[9];
//            HashSet<Character>[] setRow = new HashSet[9];//行
//            HashSet<Integer>[] columns = new HashSet[9];
//            HashSet<Integer>[] boxes = new HashSet[9];
//
//            for (int i = 0; i < 9; i++) {
//                rows[i] = new HashSet<>();
//                setRow[i]=new HashSet<>();
//                columns[i] = new HashSet<>();
//                boxes[i] = new HashSet<>();
//            }
//
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    char num = board[i][j];
//                    if (num != '.') {
//                        int n = (int) num;
//                        int box_index = (i / 3) * 3 + j / 3;
//
//                        if (!rows[i].add(n) || !columns[j].add(n) || !boxes[box_index].add(n)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//
//            return true;
//        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
