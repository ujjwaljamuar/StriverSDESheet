package Questions;

public class Q2_CheckIthBitSet {
    public static void main(String[] args) {
        int n = 9, i = 2;

        if((n & (1 << i)) != 0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
