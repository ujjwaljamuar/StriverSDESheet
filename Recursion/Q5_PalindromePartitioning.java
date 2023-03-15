import java.util.ArrayList;
import java.util.List;

public class Q5_PalindromePartitioning {

    static void partitionHelper(int index, String s, List < String > ds, List < List < String >> result) {
        if (index == s.length()) {
            result.add(new ArrayList < > (ds));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (checkPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, ds, result);
                ds.remove(ds.size() - 1);
            }
        }
    }

    static boolean checkPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static List < List < String >> partition(String s) {
        List < List < String >> result = new ArrayList < > ();
        List < String > path = new ArrayList < > ();
        partitionHelper(0, s, path, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "b11b";

        System.out.println(partition(s));
    }
}
