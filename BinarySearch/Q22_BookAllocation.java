// import java.util.*;

public class Q22_BookAllocation {

    int countStudents(int arr[], int maxPages) {
        int student = 1, pagesStudent = 0, i;

        for (i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= maxPages) {
                pagesStudent += arr[i];
            } else {
                student += 1;
                pagesStudent = arr[i];
            }
        }

        return student;
    }

    int bookAllocation(int[] arr, int students) {
        if (students > arr.length) {
            return -1;
        }

        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }

        int low = max, high = sum, mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (countStudents(arr, mid) > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    int bruteBookAllocation(int[] arr, int students) {
        if (students > arr.length) {
            return -1;
        }

        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }

        int low = max, high = sum;

        // int low = Collections.max(arr);
        // int high = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= high; pages++) {

            if (countStudents(arr, pages) == students) {
                return pages;
            }
        }

        return low;

    }

    public static void main(String[] args) {
        Q22_BookAllocation bs = new Q22_BookAllocation();

        int arr[] = { 25, 46, 28, 49, 24 };
        int students = 4;

        System.out.println(bs.bruteBookAllocation(arr, students));
        System.out.println(bs.bookAllocation(arr, students));
    }
}
