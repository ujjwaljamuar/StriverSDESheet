package Questions;

public class Q8_CountSetBits {
    public static void main(String[] args) {
        int n = 16;

        int count = 0;

        // if(n == 1){
        // count +=1 ;
        // }

        // while(n > 1){
        // count += n & 1;
        // n = n >> 1;
        // }

        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        System.out.println(count);
    }
}
