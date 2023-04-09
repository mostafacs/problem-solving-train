package mostafa.algorithms.heap;

/**
 * @Author Mostafa
 * On 11/15/22
 */
public class HeapOperations {

    public void maxHeapify(int[] data, int index) {
        int left = (index+1) * 2  -1;
        int right = (index+1) * 2 ;

        int largest = index;
        if(right < data.length && data[right] > data[index]) {
            largest = right;
        }

        if(left < data.length && data[left] > data[largest]) {
            largest = left;
        }

        if(largest  != index) {
            int tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            maxHeapify(data, largest);
        }
    }


    public void buildMaxHeapify(int[] data) {
        for (int i = data.length/2; i >= 0 ; i--) {
            System.out.println(i);
            maxHeapify(data, i);
        }
    }

    public static void main(String[] args) {
        //int[] data = {4,7,8,3,2,6,5};
        int[] data = {1, 4, 3, 7, 8, 9, 10};
        new HeapOperations().buildMaxHeapify(data); //.maxHeapify(data, 0);
        System.out.println();
    }
}
