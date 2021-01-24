class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // 这里容易出错，是 k 对 len 取模
        k %= len;
        swap(nums, 0, len - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, len - 1);
    }

    public void swap(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}