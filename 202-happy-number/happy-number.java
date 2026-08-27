class Solution {
    int sumOfSqDigits(int n)
    {
        int ans=0;
        while(n>0)
        {
            int d=n%10;
            ans=ans+(d*d);
            n/=10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(fast!=1)
        {
            slow=sumOfSqDigits(slow);
            fast=sumOfSqDigits(sumOfSqDigits(fast));
            if(fast==1)
            {
                return true;
            }
            if(fast==slow)
            {
                return false;
            }
        }
        return true;
        
    }
}