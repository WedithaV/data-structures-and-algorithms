public class Main {
    public static void main(String[] args) {
        int arr[] = { 3, -4, 5, 345, 0, -3434, 56, -37 };
        MergeSort obj = new MergeSort();
        obj.mergeSort(arr, 0, arr.length - 1);
        obj.display(arr);
    }
}

class MergeSort {
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int x = 0; x < n1; x++) {
            lArr[x] = arr[x + p];
        }

        for (int x = 0; x < n2; x++) {
            rArr[x] = arr[x + q + 1];
        }

        int i = 0;
        int j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }

    }

    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}