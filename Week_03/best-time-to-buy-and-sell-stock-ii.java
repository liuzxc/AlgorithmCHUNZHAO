// 解题思路：贪心算法
// 算法复杂度：O(N)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 注意长度要减一避免数组越界
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) profit += (prices[i + 1] - prices[i]);
        }
        return profit;
    }
}