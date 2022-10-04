package mostafa.algorithms.search;

/**
 * @author Mostafa
 *
 * Divide and Conquer algorithms
 *
 */
public class MergeSort {

    public int[] sort(int[] array) {
        sort(array, 0, array.length);
    }

    public void sort(int[] array, int l, int r) {
        if ( r <= l) return;
        int mid = l+r/2;

        int[] rightSide = new int[mid];

    }
}
