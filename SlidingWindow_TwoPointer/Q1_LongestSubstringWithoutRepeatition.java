import java.util.HashSet;
import java.util.Set;

public class Q1_LongestSubstringWithoutRepeatition {
    int bruteLengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;

        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            Set<Character> hs = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (hs.contains(s.charAt(j))) {
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

        System.out.println(swtp.bruteLengthOfLongestSubstring(str));
    }
}
