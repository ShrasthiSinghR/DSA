class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int>mp;
        for(int i=0;i<s.size();i++)
        {
            char ch=s[i];
            mp[ch]++;

        }
        int j=0;

        while(j<s.size())
        {
            char ch=s[j];
            if(mp[ch]==1)
            {
                return j;
               
            }
            j++;
        }
        return -1;
        
    }
};