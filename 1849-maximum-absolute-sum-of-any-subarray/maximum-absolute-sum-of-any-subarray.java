class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int bestfinding = 0;
        int minfinding = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            bestfinding = Math.max(nums[i], bestfinding + nums[i]);

            minfinding = Math.min(nums[i], minfinding + nums[i]);

            res = Math.max(res, Math.max(bestfinding, -minfinding));
        }

        return res;
    }
}