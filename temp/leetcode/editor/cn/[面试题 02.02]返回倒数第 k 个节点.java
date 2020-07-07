//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_面试02_02 {
    public int kthToLast(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode s = pre, p = pre;
        while (k-- != 0) {
            s = s.next;
        }
        while (s.next != null) {
            s = s.next;
            p = p.next;
        }
        return p.next.val;//返回第k个节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)
