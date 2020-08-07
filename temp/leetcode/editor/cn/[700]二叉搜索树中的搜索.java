//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 
// 👍 79 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int val;
    TreeNode ans = null;

    public TreeNode searchBST(TreeNode root, int val) {
        this.val = val;
        isInTree(root);
        return ans;
    }

    private void isInTree(TreeNode root) {
        if (root == null) return;
        if (root.val == val) {
            ans = root;
            return;
        } else if (val > root.val) isInTree(root.right);
        else if (val < root.val) isInTree(root.left);
    }

//    //迭代
//    public TreeNode searchBST(TreeNode root, int val) {
//        while (root != null) {
//            if (root.val == val) {
//                return root;
//            } else if (root.val > val) {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//        return null;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
