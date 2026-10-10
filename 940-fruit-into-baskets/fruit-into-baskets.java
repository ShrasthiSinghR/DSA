
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int high = 0;
        int res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (high < fruits.length) {
            // 1. Include high
            int ch = fruits[high];
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // 2. Shrink while distinct fruit types > 2
            while (map.size() > 2) {
                int leftFruit = fruits[low];

                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                low++;
            }

            // 3. Update maximum window length
            res = Math.max(res, high - low + 1);

            // 4. Move high
            high++;
        }

        return res;
    }
}
