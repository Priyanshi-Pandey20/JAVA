
public class Sort {

    public static void MergeSort(int[] arr, int l, int h) {

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

        for ( k = 0, i = l; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 8, 2, 1 };
        MergeSort(arr, 0, arr.length-1);
        PrintArr(arr);
    }
}
