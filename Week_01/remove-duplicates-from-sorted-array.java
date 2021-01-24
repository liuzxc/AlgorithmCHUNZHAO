class Solution {
    public int removeDuplicates(int[] nums) {
        // 利用双指针法
        int len = nums.length;
        int i = 0;
        for (int j = i+1; j < len; j++) {
            // 遇到值不同的就把左指针的前一位覆盖掉
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
