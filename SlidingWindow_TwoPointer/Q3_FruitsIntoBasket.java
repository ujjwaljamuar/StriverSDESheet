import java.util.HashSet;
import java.util.Set;

public class Q3_FruitsIntoBasket {
    int bruteFruitsIntoBasket(int[] arr){
        int maxLen = 0;

        for(int i = 0; i < arr.length; i++){
            Set<Integer> hs = new HashSet<>();

            for(int j = i; j < arr.length; j++){
                hs.add(arr[j]);

                if(hs.size() <= 2){
                    maxLen = Math.max(maxLen, j-i + 1);
                }
                else{
                    break;
                }
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        Q3_FruitsIntoBasket swtp = new Q3_FruitsIntoBasket();

        int[] arr = {3, 1, 2, 2, 2, 2};

        System.out.println(swtp.bruteFruitsIntoBasket(arr));
    }
}
