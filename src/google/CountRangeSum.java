package google;

/**
 * Created by rh727 on 9/3/18.
 */
public class CountRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        return mergesort(sums, new long[nums.length + 1], lower, upper, 0, nums.length);
    }

    public int mergesort(long[] sums, long[] tmp, int lower, int upper, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergesort(sums, tmp, lower, upper, left, mid) + mergesort(sums, tmp, lower, upper, mid + 1, right);
        for (int i = left; i <= right; i++) tmp[i] = sums[i];

        int isum = left, idt = mid + 1;
        for (int i = left; i <= mid; i++) {
            int id1 = mid + 1, id2 = mid + 1;
            while (id1 <= right && tmp[id1] - tmp[i] < lower) id1++;
            while (id2 <= right && tmp[id2] - tmp[i] <= upper) id2++;
            while (idt <= right && tmp[idt] <= tmp[i]) sums[isum++] = tmp[idt++];
            sums[isum++] = tmp[i];
            count += id2 - id1;
        }


        return count;
    }
}
