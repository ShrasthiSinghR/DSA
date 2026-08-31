class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();

        unordered_map<int, int> mp;

        long long sum = 0;
        long long maxSum = 0;

        int i = 0;

        for (int j = 0; j < n; j++) {

            // Add current element
            sum += nums[j];
            mp[nums[j]]++;

            // Keep window size <= k
            if (j - i + 1 > k) {
                sum -= nums[i];
                mp[nums[i]]--;

                if (mp[nums[i]] == 0) {
                    mp.erase(nums[i]);
                }

                i++;
            }

            // If window size is k and all elements are distinct
            if (j - i + 1 == k && mp.size() == k) {
                maxSum = max(maxSum, sum);
            }
        }

        return maxSum;
    }
};