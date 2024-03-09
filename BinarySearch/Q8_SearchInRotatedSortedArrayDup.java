public class Q8_SearchInRotatedSortedArrayDup {
    boolean search(int[] arr, int n, int target){
        int low = 0, mid, high = n - 1;

        while(low <= high){
            mid = low + ((high - low)/2);
            
            if(arr[mid] == target){
                return true;
            }

            // trim down the search space
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            } 

            // left is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid -1;
                }
                low = mid +1;
            }
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }else{
                    high = mid -1 ;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Q8_SearchInRotatedSortedArrayDup srch = new Q8_SearchInRotatedSortedArrayDup();

        int arr[] = {3, 4, 5, 0, 0, 1, 2};
        int target = 4;
        int n = arr.length;

        System.out.println(srch.search(arr, n, target));
    }
}
