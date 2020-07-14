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
    //q节点遍历数据 然后判断到q的值小于x就交换
    public ListNode partition(ListNode head, int x) {
        ListNode p, q;
        p = q = head;
        while (q != null) {
            if (q.val < x) {//小就发生交换 并对p进行next
                int t = q.val;
                q.val = p.val;
                p.val = t;
                p = p.next;//游标
            }
            q = q.next;
        }
        return head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
