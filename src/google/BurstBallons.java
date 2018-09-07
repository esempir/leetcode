package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rh727 on 9/2/18.
 */
public class BurstBallons {
    int max = 0;

    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        countCoins(list, 0);
        return max;
    }

    public void countCoins(List<Integer> list, int coins) {
        if (list.size() == 1) {
            coins += list.get(0);
            max = Math.max(max, coins);
            return;
        }


        for (int i = 0; i < list.size(); i++) {
            int left = i == 0? 1 : list.get(i - 1);
            int right = i == list.size() - 1? 1 : list.get(i + 1);
            List<Integer> newList = new ArrayList<>(list.subList(0, i));
            System.out.println(list);
            System.out.println(" " + newList);
            newList.addAll(list.subList(i + 1, list.size()));
            System.out.println(" " + newList);
            countCoins(newList, coins + left * list.get(i) * right);
        }
        return;
    }
}
