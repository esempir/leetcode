package google;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rh727 on 8/5/18.
 */

// last day with m groups of flowers, distance between each group >= k
public class KEmptySlots_GroupM {

    int[] BIT;

    // flower[i] = d, position i blossom on day d
    // the key problem is to find the nearest ones on it's left and right in O(logn)
    // Treeset
    public int KEmptySlots_GroupM(int[] flowers, int k, int m) {
        BIT = new int[flowers.length + 1];

        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i;
        }

        Set<Integer> set = new HashSet<>();
        int group = 0;
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
            //update(days[i]);
            int left = days[i], right = days[i];
            for (; left >= 0; left--) {
                if (set.contains(left)) break;
            }
            for (; right < flowers.length; right++) {
                if (set.contains(right)) break;
            }
            int newgroup = group;
            if (left >= 0 && (days[i] - left) >= k ) {
                newgroup++;
            }
            if (right < flowers.length && (right - days[i]) >= k) {
                newgroup++;
            }
            if (left >= 0 && right < flowers.length && (right - left) >= k) {
                newgroup--;
            }
            if (group == m && newgroup != m) {
                return i;
            }
            group = newgroup;
        }

        return -1;
    }

    // O(logn)
    private void update(int i) {
        while (i < BIT.length) {
            BIT[i] += 1;
            i += i & (-i);
        }
    }

    // O(logn)
    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= i & (-i);
        }
        return sum;
    }
}
