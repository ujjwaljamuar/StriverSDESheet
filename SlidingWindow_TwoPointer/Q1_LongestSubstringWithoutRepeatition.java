import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1_LongestSubstringWithoutRepeatition {
    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        int l = 0, r = 0, maxLen = 0, size = s.length();

        while (r < size) {
            if (hm.containsKey(s.charAt(r))) {
                l = Math.max(hm.get(s.charAt(r)) + 1, l);
            }

            hm.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    int bruteLengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;

        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            Set<Character> hs = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (hs.contains(s.charAt(j))) {
                    System.out.println(j - i);
                    maxLen = Math.max(maxLen, j - i);
                    break;
                }

                hs.add(s.charAt(j));
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Q1_LongestSubstringWithoutRepeatition swtp = new Q1_LongestSubstringWithoutRepeatition();

        String str = "takeUforward";

        System.out.println(swtp.lengthOfLongestSubstring(str));
    }
}
