package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rh727 on 9/4/18.
 */
public class FlipGame {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return canWin(s, map);
    }

    public boolean canWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                s = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                if (!canWin(s, map)) return true;
            }
        }

        map.put(s, true);
        return true;
    }
}
