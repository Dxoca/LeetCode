//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
// Related Topics 链表 双指针

//leetcode submit region begin(Prohibit modification and deletion)

class Solution_Offer_22 {
//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode s = pre, p = pre;
        while (k-- != 0) {
            s = s.next;
        }
        while (s.next != null) {
            s = s.next;
            p = p.next;//p是从空节点开始移动的
        }
//        p.next = p.next.next;
        return p.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
