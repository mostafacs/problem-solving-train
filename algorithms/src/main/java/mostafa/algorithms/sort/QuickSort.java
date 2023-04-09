package mostafa.algorithms.sort;

/**
 * @author Mostafa
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] data = {10, 80, 30, 90, 40, 50, 70};
        new QuickSort().sort(data);
        printArray(data);

    }


    public void sort(int[] data) {
        quickSort(data, 0, data.length-1);
   }

    private void quickSort(int[] data, int start, int end) {

        if (start < end) {
            System.out.println("Start="+start+" , End="+end + " , Pivot="+data[end]);
            int splitter = partition(data, start, end);
            System.out.println("Splitter = "+splitter);
            quickSort(data, start, splitter-1);
            quickSort(data, splitter+1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        int lowerTracker = start-1;
        int pivot = data[end];
        for (int i = start; i <= end-1; i++) {
            if(data[i] < pivot) {
                lowerTracker++;
                swap(data, i, lowerTracker);
            }
        }
        swap(data, lowerTracker+1, end);
        return lowerTracker+1;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+", ");
        }
        System.out.println();
    }
}
