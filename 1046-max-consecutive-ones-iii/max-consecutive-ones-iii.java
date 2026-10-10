
class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int res = 0;
        int zeros = 0;

        while (high < nums.length) {
            // 1. Include high
            if (nums[high] == 0) {
                zeros++;
            }

            // 2. Shrink if zeros > k
            while (zeros > k) {
                if (nums[low] == 0) {
                    zeros--;
                }
                low++;
            }

            // 3. Update answer
            res = Math.max(res, high - low + 1);

            // 4. Move high
            high++;
        }

        return res;
    }
}
