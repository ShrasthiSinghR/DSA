
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int res = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (high < s.length()) {
            // 1. Include high
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // 2. Shrink while duplicate exists
            while (map.get(ch) > 1) {
                char leftChar = s.charAt(low);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                low++;
            }

            // 3. Update answer
            int len = high - low + 1;
            res = Math.max(res, len);

            // 4. Move high
            high++;
        }

        return res;
    }
}
