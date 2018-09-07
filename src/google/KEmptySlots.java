package google;

/**
 * Created by rh727 on 7/21/18.
 */
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers.length < k + 1) {
            return  -1;
        }

        int[] dates = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            dates[flowers[i] - 1] = i + 1;
        }
        int result = Integer.MAX_VALUE;
        int left = 0, right = k + 1;
        for (int i = 1; right < dates.length; i++) {
            if (dates[i] < dates[left] || dates[i] <= dates[right]) {
                if (i == right) {
                    result = Math.min(result, Math.max(dates[left], dates[right]));
                }
                left = i;
                right = left + k + 1;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
