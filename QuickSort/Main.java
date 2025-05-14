public class Main {
    public static void main(String[] args) {
        int arr[] = { 23, -43, 2334, 0, 43, 98, 1 };
        printArray(arr);
        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("Sorted array");
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class QuickSort {
    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {

            while (left <= right && arr[left] <= pivot) { // left <= right use to avoid ArrayIndexOutOfBoundsException.
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, right);
        return right;
    }

    public void swap(int arr[], int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}