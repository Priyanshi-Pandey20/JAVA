import java.util.*;

public class Sorting {
    public static void MergeSort(int[] arr, int l, int h) {// merge sort //O(n)

        if (l >= h) {
            return;
        }
        int mid = (l + h) / 2;
        MergeSort(arr, l, mid);
        MergeSort(arr, mid + 1, h);
        merge(arr, l, mid, h);

    }

    public static void merge(int[] arr, int l, int mid, int h) {
        int[] temp = new int[h - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= h) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;

            } else {
                temp[k] = arr[j];
                j++;

            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= h) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = l; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void QuickSort(int[] arr, int lb, int ub) { // Quick sort
        int x, l, r;
        if (lb >= ub) {
            return;
        }
        l = lb;
        r = ub;
        x = arr[lb];

        while (l < r) {
            while (arr[l] <= x && l < r) {
                l++;
            }
            while (arr[r] > x) {
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

        }
        arr[lb] = arr[r];
        arr[r] = x;
        QuickSort(arr, lb, r - 1);
        QuickSort(arr, r + 1, ub);

    }

    public static void BubbleSort(int[] arr) { // Bubble Sort O(n^2)
        for (int turn = 0; turn < arr.length; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(arr[turn]);
        }
    }

    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void heapify(int[] arr, int i, int size) { // to sort the heap in asecnding order
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void HeapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static int SearchInRoatedArray(int[] nums, int tar, int si, int ei) { // using recursion
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        if (nums[mid] == tar) {
            return mid;
        }
        if (nums[si] <= nums[mid]) {
            if (nums[si] <= tar && tar <= nums[mid]) {
                return SearchInRoatedArray(nums, tar, si, mid);
            } else {
                return SearchInRoatedArray(nums, tar, mid + 1, ei);
            }
        } else {
            if (nums[mid] <= tar && tar <= nums[ei]) {
                return SearchInRoatedArray(nums, tar, mid + 1, ei);
            } else {
                return SearchInRoatedArray(nums, tar, si, mid - 1);
            }
        }
    }

    public static int search(int[] nums, int tar, int si, int ei) { // using loops search element in roated array
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == tar) {
                return mid;
            }

            if (nums[si] <= nums[mid]) {
                if (nums[si] <= tar && tar <= nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (nums[mid] <= tar && tar <= nums[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }

        }
        return -1;
    }

    public static String[] mergeSort(String[] a, int lo, int hi) { // To sort a string array according to starting
                                                                   // character

        if (lo == hi) { // base case
            String[] A = { a[lo] };
            return A;
        }

        int mid = lo + (hi - lo) / 2;
        String[] arr1 = mergeSort(a, lo, mid);
        String[] arr2 = mergeSort(a, mid + 1, hi);

        String[] arr3 = Merge(arr1, arr2);
        return arr3;

    }

    public static String[] Merge(String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        String[] arr3 = new String[m + n];

        int idx = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (isAlphabetSmaller(arr1[i], arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
                idx++;
            } else {
                arr3[idx] = arr2[j];
                j++;
                idx++;
            }
        }

        while (i < m) {
            arr3[idx] = arr1[i];
            i++;
            idx++;
        }
        while (j < n) {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }
        return arr3;
    }

    public static boolean isAlphabetSmaller(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static int MajorityElement(int arr1[]) { // majority occurring element
        int majority = arr1.length / 2;

        for (int i = 0; i < arr1.length; i++) {
            int count = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    count++;
                }
            }
            if (count > majority) {
                return arr1[i];
            }
        }
        return -1;

    }

    public static int InversionCount(int[] arr2) { // Iversion count
        int count = 0;
        for (int i = 0; i < arr2.length - 1; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i] > arr2[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = { 5, 9, 8, 2, 1 };
        HeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();

    }

}
