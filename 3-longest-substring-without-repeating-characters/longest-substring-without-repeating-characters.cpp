class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;

        for(int i = 0; i < s.size(); i++) {

            for(int j = i; j < s.size(); j++) {

                bool repeat = false;

                for(int k = i; k < j; k++) {
                    if(s[k] == s[j]) {
                        repeat = true;
                        break;
                    }
                }

                if(repeat)
                    break;

                ans = max(ans, j - i + 1);
            }
        }

        return ans;
    }
};