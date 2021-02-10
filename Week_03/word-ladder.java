// 解题思路：找最短路径的话一般使用 BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 wordlist 转换为 set
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 找到 endWord 后就退出
                if (checkWord(word, endWord, queue, visited, wordSet)) {
                    return count + 1;
                }
            }
            count++;
        }
        // 注意这里是 return 0 而不是 count
        return 0;
    }

    public boolean checkWord(
            String word,
            String endWord,
            Queue<String> queue,
            Set<String> visited,
            Set<String> wordSet) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char oldChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) return true;
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.add(nextWord);
                    }
                }
            }
            charArray[i] = oldChar;
        }
        return false;
    }
}