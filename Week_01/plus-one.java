class Solution {
    public int[] plusOne(int[] digits) {
        // 从数组末尾开始判断，超过9就进位（首位大于9要增加数组长度)
        // 没有超过9，+1 return
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}