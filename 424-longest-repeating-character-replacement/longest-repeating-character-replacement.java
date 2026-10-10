
import java.util.*;

class Solution {

    public int getMaxFreq(HashMap<Character, Integer> map) {
        int maxFreq = 0;

        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        int low = 0, high = 0, res = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (high < s.length()) {
            char ch = s.charAt(high);

            // Include high
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Calculate maximum frequency
            int maxFreq = getMaxFreq(map);

            // Shrink invalid window
            while (high - low + 1 - maxFreq > k) {
                char left = s.charAt(low);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                low++;

                maxFreq = getMaxFreq(map);
            }

            res = Math.max(res, high - low + 1);
            high++;
        }

        return res;
    }
}
