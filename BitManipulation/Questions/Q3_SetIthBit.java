package Questions;

public class Q3_SetIthBit {
    public static void main(String[] args) {
        int n = 9, i = 2;

        n = n | (1 << i);

        System.out.println(n);
    }
}
