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

// 算法复杂度：O(n)
// 空间复杂度：O(n)
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        // 需要遍历子节点
        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }
}