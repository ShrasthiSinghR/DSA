
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        while (high < nums.length) {

            // 1. Include high
            sum = sum + nums[high];

            // 2. Shrink while window is valid
            while (sum >= target) {
                int len = high - low + 1;
                result = Math.min(result, len);

                sum = sum - nums[low];
                low++;
            }

            // 3. Move high
            high++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
