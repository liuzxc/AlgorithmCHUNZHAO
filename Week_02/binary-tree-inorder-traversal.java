/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 时间复杂度：O(N)
// 空间复杂度：O(N)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        // 设置阻断条件
        if (root == null) return;
        // 处理左子树
        inOrder(root.left, res);
        // 处理当前节点
        res.add(root.val);
        // 处理右子树
        inOrder(root.right, res);
    }
}