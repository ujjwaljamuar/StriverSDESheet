package InterviewQuestions;

public class Q1_FlipBitsToConvert {

    int bitsFlipped(int start, int goal){
        // xor operation will spare bits which needs to be changed
        int  ans = Integer.parseInt(Integer.toBinaryString(start ^ goal), 2);

        int count = 0;

        // count set bits
        while(ans != 0){
            ans = ans & ans - 1;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Q1_FlipBitsToConvert bitwise = new Q1_FlipBitsToConvert();

        int start = 3, goal = 4;

        System.out.println(bitwise.bitsFlipped(start, goal));
    }
}
