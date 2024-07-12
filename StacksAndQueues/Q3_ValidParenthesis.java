import java.util.Stack;

public class Q3_ValidParenthesis {
    boolean isBalanced(String s) {
        char[] charArr = s.toCharArray();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < charArr.length; i++) {
            if (
                (charArr[i] == '[') ||
                (charArr[i] == '{') ||
                (charArr[i] == '(')
                ) {
                st.push(charArr[i]);
            }

            else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                    if (
                        (charArr[i] == ']' && c == '[') ||    
                        (charArr[i] == '}' && c == '{') ||
                        (charArr[i] == ')' && c == '(')
                        ) {
                        continue;
                    }

                    else {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Q3_ValidParenthesis sq = new Q3_ValidParenthesis();

        String s = "()[{}()]";

        System.out.println(sq.isBalanced(s));
    }
}
