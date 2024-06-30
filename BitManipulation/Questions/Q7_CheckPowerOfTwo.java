package Questions;

public class Q7_CheckPowerOfTwo {
    public static void main(String[] args) {
        int n = 18;

        if((n & n-1) == 0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
