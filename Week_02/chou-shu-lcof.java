// 解题思路：丑数的倍数也是丑数
// 构造小顶堆，弹出的第 N 个元素即是目标值
// 算法复杂度：O(N)
class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<Long>();
        // 设置队列初始值
        pq.add(1L);
        int[] ugs = new int[] {2, 3, 5};
        // 因为有初始值，所以 count  默认值是 1
        int count = 1;
        while (count < n) {
            // 取出队顶元素并从队列中删除，目的是保证队顶始终是最小值
            long temp = pq.poll();
            count++;
            for (int num : ugs) {
                long value = num * temp;
                // 添加元素的时候需要去重
                if (pq.contains(value) == false) {
                    pq.add(value);
                }
            }
        }
        return (int)(long) pq.peek();
    }
}