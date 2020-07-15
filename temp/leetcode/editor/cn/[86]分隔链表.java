//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 224 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //维护两条链表，利用尾插法保证相对顺序不变
        ListNode min = new ListNode(-1);
        ListNode max = new ListNode(-1);
        ListNode p = head, p1 = min, p2 = max;//mark 链表的头。

        while (p != null) {
            if (p.val < x) {
                min.next = p;
                min = min.next;
            } else {
                max.next = p;
                max = max.next;
            }
            p = p.next;
        }
        min.next = p2.next;//小的尾巴指向大的头部 尾插法
        max.next = null;//对于非空表，将尾结点指针域置空 否则 Error - Found cycle in the ListNode
        return p1.next;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
