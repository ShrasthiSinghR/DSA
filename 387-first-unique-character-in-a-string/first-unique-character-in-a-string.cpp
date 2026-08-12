class Solution {
public:
    int firstUniqChar(string s) {
        int freq[26] = {0};

        // Step 1: Count frequency
        for (char ch : s) {
            freq[ch - 'a']++;
        }

        // Step 2: Put characters in stack
        stack<pair<char, int>> st;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (freq[s[i] - 'a'] == 1) {
                st.push({s[i], i});
            }
        }

        // Step 3: Top is the first unique character
        if (!st.empty()) {
            return st.top().second;
        }

        return -1;
    }
};