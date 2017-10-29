package randomExamples;

/**
 * Created by anandmishra on 25/10/17.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {6,5,1,3,8,4,2,9,7};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotLocation = partition(arr,low,high);
            quickSort(arr, low, pivotLocation - 1);
            quickSort(arr, pivotLocation + 1, high);
        }
    }

    static int partition(int[] a, int low, int high){

        int leftWall = low - 1;
        int pivot = a[high];

        for (int i = low; i < high; i++){
            if (a[i] <= pivot) {
                leftWall++;
                int temp = a[leftWall];
                a[leftWall] = a[i];
                a[i] = temp;
            }
        }

        int temp = a[leftWall + 1];
        a[leftWall + 1] = a[high];
        a[high] = temp;

        return leftWall + 1;
    }
}
