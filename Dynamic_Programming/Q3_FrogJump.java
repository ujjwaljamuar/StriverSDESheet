public class Q3_FrogJump {

    int minimumEnergyRec(int[] arr, int n){
        if(n == 0){
            return 0;
        }

        int rightRec = Integer.MAX_VALUE;
        int leftRec = minimumEnergyRec(arr, n-1) + Math.abs(arr[n] - arr[n-1]);
        if(n > 1){
            rightRec = minimumEnergyRec(arr, n-2) + Math.abs(arr[n] - arr[n-2]);
        }
        
        return Math.min(leftRec, rightRec);
    }
    public static void main(String[] args) {
        Q3_FrogJump dp = new Q3_FrogJump();

        int[] arr = {10, 20, 30, 10};
        int n = 4;

        System.out.println(dp.minimumEnergyRec(arr, n-1));
    }
}
