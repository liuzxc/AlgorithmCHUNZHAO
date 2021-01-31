/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// 时间复杂度：O(N)
// 空间复杂度：O(N)
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        // 先设置阻断条件
        if (root == null) return res;
        // 先处理当前节点
        res.add(root.val);
        // 遍历子节点
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }
}