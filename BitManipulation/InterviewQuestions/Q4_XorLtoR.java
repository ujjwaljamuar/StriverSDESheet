package InterviewQuestions;

public class Q4_XorLtoR {
    int logicFunc(int n) {
        if (n % 4 == 1) {
            return 1;
        }

        else if (n % 4 == 2) {
            return n + 1;
        }

        else if (n % 4 == 3) {
            return 0;
        }

        else {
            return n;
        }
    }

    int findXor(int L, int R) {
        return logicFunc(L - 1) ^ logicFunc(R);
    }

    public static void main(String[] args) {
        Q4_XorLtoR bitwise = new Q4_XorLtoR();

        int L = 4, R = 8;

        System.out.println(bitwise.findXor(L, R));
    }
}
