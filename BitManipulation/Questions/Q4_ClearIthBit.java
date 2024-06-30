package Questions;

public class Q4_ClearIthBit {
    public static void main(String[] args) {
        int n = 13, i = 2;
        // answer will be 9

        System.out.println(n & ~(1 << i));
        
    }
}
