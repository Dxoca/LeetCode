//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
// 
// Related Topics 链表 双指针 
// 👍 21 👎 0
//双指针法，思路类似于“荷兰国旗🇳🇱”的颜色排序题目.
//p指针左边必定是小于x的节点，q指针遍历链表，遇到val<x时，交换p,q的val，并且p=p.next
//
//        作者：bu-hui-er-cha-shu
//        链接：https://leetcode-cn.com/problems/partition-list-lcci/solution/shuang-zhi-zhen-by-bu-hui-er-cha-shu/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode p, q;
        p = q = head;
        while (q != null) {
            if (q.val < x) {//肯定是大于等于的交换
                int t = q.val;
                q.val = p.val;
                p.val = t;
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
