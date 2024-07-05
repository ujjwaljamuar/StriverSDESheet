package InterviewQuestions;

public class Q2_SingleNumber {

    int findSingleNumber(int[] nums) {
        int num = 0;

        for (int it : nums) {
            num = num ^ it;
        }

        return num;
    }

    public static void main(String[] args) {
        Q2_SingleNumber bitwise = new Q2_SingleNumber();

        int[] nums = { 1, 2, 2, 1, 3 };

        System.out.println(bitwise.findSingleNumber(nums));
    }
}
