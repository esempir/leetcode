package google;

/**
 * Created by rh727 on 7/15/18.
 */
import java.util.*;

// 681
public class NextClosestTime {
    int min = 1440;
    int[] res;
    public String nextClosestTime(String time) {
        int[] num = new int[4];
        Set<Integer> set = new HashSet<Integer>();
        num[0] = time.charAt(0) - '0';
        set.add(num[0]);
        num[1] = time.charAt(1) - '0';
        set.add(num[1]);
        num[2] = time.charAt(3) - '0';
        set.add(num[2]);
        num[3] = time.charAt(4) - '0';
        set.add(num[3]);

        int[] arr = new int[]{-1, -1, -1, -1};
        dfs(num, arr, 0, set);

        if (res == null) {
            return time;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(res[0]);
        sb.append(res[1]);
        sb.append(':');
        sb.append(res[2]);
        sb.append(res[3]);

        return sb.toString();
    }

    private void dfs(int[] num, int[] target, int cur, Set<Integer> set) {
        if (cur == 4) {
            int thisDist = dist(num, target);
            if (thisDist != 0 && thisDist < min) {
                min = thisDist;
                res = Arrays.copyOf(target, 4);
            }
            return;
        }
        for (Integer i : set) {
            if (cur == 0 && i > 2) continue;
            if (cur == 1 && (target[0] * 10 + i) > 23) continue;
            if (cur == 2 && i > 5) continue;
            if (cur == 3 && (target[2] * 10 + i) > 59) continue;
            target[cur] = i;
            dfs(num, target, cur + 1, set);
        }
    }

    private int dist(int[] t1, int[] t2) {
        int m1 = (t1[0] * 10 + t1[1]) * 60 + t1[2] * 10 + t1[3];
        int m2 = (t2[0] * 10 + t2[1]) * 60 + t2[2] * 10 + t2[3];
        if (m1 > m2) {
            return 1440 + m2 - m1;
        }
        return m2 - m1;
    }
}
