// 解题思路: 贪心算法
// 算法复杂度O(N)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 判断边界条件
        if (bills.length == 0) return true;
        if (bills[0] != 5) return false;
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                fives--;
                tens++;
            } else {
                if (fives > 0 && tens > 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else return false;
            }
        }
        return true;
    }
}