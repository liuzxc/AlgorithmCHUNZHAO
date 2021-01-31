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

// 算法负责度O(N)
// 空间复杂度O(N)
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return list;
        helper(root, 0);
        return list;
    }

    public void helper(Node root, int level) {
        // 每增加一层，需要新建一个数组保存值
        if (list.size() <= level) list.add(new ArrayList<Integer>());
        list.get(level).add(root.val);
        // 处理子节点
        for (Node node : root.children) {
            helper(node, level+1);
        }
    }
}