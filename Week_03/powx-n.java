// 解题思路：采用分治思想
// 算法复杂度O(logn)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        // 对负数要做特殊处理
        return N > 0 ? quickCal(x, N) : 1 / quickCal(x, -N);

    }

    public double quickCal(double x, long n) {
        // 设置结束条件
        if (n == 0) return 1.0;
        // 递归
        double result = quickCal(x, n / 2);
        // 奇偶数判断，奇数要多乘一个x
        return n % 2 == 1 ? result * result * x : result * result;
    }
}