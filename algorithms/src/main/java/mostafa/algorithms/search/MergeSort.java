package mostafa.algorithms.search;

/**
 * @author Mostafa
 *
 * Divide and Conquer algorithms
 *
 */
public class MergeSort {


    public static void main(String[] args) {
        new MergeSort().sort(new int[]{6,3,5,6,1,5,2,0});
    }
    public void sort(int[] array) {
        mergeSort(array);
    }

    private void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length/2;

        int[] leftSide = new int[mid];
        int[] rightSide = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            leftSide[i] = array[i];
        }

        for (int i = 0; i < rightSide.length; i++) {
            rightSide[i] = array[mid+i];
        }

        mergeSort(rightSide);
        mergeSort(leftSide);


        merge(array, leftSide, rightSide);
        System.out.println("--------------------------------------");
        System.out.println("-- Left Side --");
        printArray(leftSide);
        System.out.println("-- Right Side --");
        printArray(rightSide);
        System.out.println("-- Merged array --");
        printArray(array);
        System.out.println("-------------------------------------");
    }



    private void merge(int[] original, int[] leftSide, int[] rightSide) {
        int o=0, l=0, r=0;

        // because left side and right side must be sorted
        while ( l < leftSide.length && r < rightSide.length) {

            if(leftSide[l] <= rightSide[r]) {
                original[o] = leftSide[l];
                l++;
            }
            else {
                original[o] = rightSide[r];
                r++;
            }
            o++;
        }


        for (int i = l; i < leftSide.length; i++) {
            original[o] = leftSide[l];
            o++;
        }

        for (int i = r; i < rightSide.length; i++) {
            original[o] = rightSide[r];
            o++;
        }

    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }
}
