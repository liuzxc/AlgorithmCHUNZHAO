// 解题思路：BFS + 将访问路径保存在队列中而不只是节点的值
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return res;
        // 将每一层的结果放在队列中
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        // 保存访问过的节点
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        // 设置最短路径的标志
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            // size 表示当前层有多少个节点，每个节点需要逐个遍历
            int size = queue.size();
            // 重点：这里要单独保存访问过的每一层的节点信息，如果直接加入 visited，会导致
            // 只有一条路径被计算到，剩下的被忽略了
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                // 节点保存的是完整的路径信息，路径的最后一个元素就是节点的值
                String word = path.get(path.size() -1);
                char[] charArray = word.toCharArray();
                // 更改每一个字符的值，找到匹配 wordSet 的字符串，比如 hot -> dot/lot
                for (int j = 0; j < endWord.length(); j++) {
                    char oldChar = charArray[j];
                    // 字符从 a 遍历到 z
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = new String(charArray);
                        // 如果新组合的单词在集合中且没有被访问过，就是我们要找的目标值
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            // 当前路径的信息加上目标值就是到下一个节点的路径
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(nextWord);

                            queue.add(pathList);
                            subVisited.add(nextWord);

                            if (endWord.equals(nextWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                        }
                    }
                    charArray[j] = oldChar;
                }
            }
            visited.addAll(subVisited);
        }
        return res;
    }
}