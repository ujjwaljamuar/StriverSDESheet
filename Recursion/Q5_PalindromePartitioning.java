import java.util.ArrayList;
import java.util.List;

public class Q5_PalindromePartitioning {

    static void findSubstring(int index, String s, List<String> ds, List<List<String>> result) {
        // base case
        if (index == s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }

        // loop through end
        for (int i = index; i < s.length(); ++i) {
            if (checkPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                findSubstring(i + 1, s, ds, result);
                ds.remove(ds.size() - 1);
            }
        }
    }

    static boolean checkPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;

    }

    static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        findSubstring(0, s, ds, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabb";

        System.out.println(partition(s));
    }
}
