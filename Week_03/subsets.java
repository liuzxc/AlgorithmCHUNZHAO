// 解题思路：采用回溯算法
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // res 保存最终结果
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(
            int i,
            int[] nums,
            List<List<Integer>> res,
            ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(j + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }

    }
}