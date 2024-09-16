public class Q4_Lemonade_Exchange {

    boolean lemonade_exchange(int[] bills) {
        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five += 1;
            }

            else if (bills[i] == 10) {
                if (five > 0) {
                    five -= 1;
                    ten += 1;
                } else {
                    return false;
                }
            }

            else {
                if (five > 0 && ten > 0) {
                    five -= 1;
                    ten -= 1;
                }

                else if (five >= 3) {
                    five -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Q4_Lemonade_Exchange grd = new Q4_Lemonade_Exchange();

        int[] bills = { 5, 5, 10, 10, 20 };

        System.out.println(grd.lemonade_exchange(bills));
    }
}
