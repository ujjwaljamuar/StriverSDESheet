import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Q3_FruitsIntoBasket {
    int fruitsIntoBasket(int[] arr) {
        int maxLen = 0;
        int l = 0, r = 0;

        HashMap<Integer, Integer> hmap = new HashMap<>();

        while (r < arr.length) {
            if (hmap.containsKey(arr[r])) {
                hmap.put(arr[r], hmap.get(arr[r]) + 1);
            } else {
                hmap.put(arr[r], 1);
            }

            if (hmap.size() > 2) {
                hmap.put(arr[l], hmap.get(arr[l]) - 1);

                if (hmap.get(arr[l]) == 0) {
                    hmap.remove(arr[l]);
                }

                l++;
            }

            if (hmap.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

    int bruteFruitsIntoBasket(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> hs = new HashSet<>();

            for (int j = i; j < arr.length; j++) {
                hs.add(arr[j]);

                if (hs.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Q3_FruitsIntoBasket swtp = new Q3_FruitsIntoBasket();

        int[] arr = { 3, 1, 2, 2, 2, 2 };

        System.out.println(swtp.bruteFruitsIntoBasket(arr));
        System.out.println(swtp.fruitsIntoBasket(arr));
    }
}
