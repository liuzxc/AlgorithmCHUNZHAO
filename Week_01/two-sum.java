class Solution {
    public int[] twoSum(int[] nums, int target) {
        // a + b = target, a = target -b
        // 使用 hashmap 缓存
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int value = target - nums[i];
            if (hm.containsKey(value)) {
                return new int[] {i, hm.get(value)};
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}