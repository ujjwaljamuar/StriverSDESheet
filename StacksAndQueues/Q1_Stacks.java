public class Q1_Stacks {
    private class Stackk {
        int size = 10000;
        int[] arr = new int[size];
        int top = -1;

        void push(int n) {
            if (top < size - 1) {
                top++;
                arr[top] = n;
            } else {
                System.out.println("Stack overflow");
            }
        }

        int pop() {
            if (top >= 0) {
                int x = arr[top];
                top--;
                return x;
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top() {
            if (top >= 0) {
                return arr[top];
            } else {
                System.out.println("Stack is empty");
                return -1;
            }
        }

        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        Q1_Stacks sq = new Q1_Stacks();

        Stackk s = sq.new Stackk();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s.top());

        System.out.println(s.pop());

        System.out.println(s.top());

        System.out.println(s.size());
    }
}
