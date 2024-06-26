public class DecimalToBinary {
    static int decToBin(int n) {
        StringBuilder sb = new StringBuilder("");
        while (n > 0) {
            if (n % 2 == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            n /= 2;
        }

        return Integer.parseInt(sb.reverse().toString());
    }

    static int binToDec(String str){
        int n = str.length();
        int res = 0;

        for(int i = n - 1; i > 0; i--){
            if(str.charAt(i) == '1'){
                res += (int)str.charAt(i) * Math.pow(2, i - (n-1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(decToBin(16));

        System.out.println(Integer.toBinaryString(16));

        System.out.println(binToDec("10000"));
    }
}
