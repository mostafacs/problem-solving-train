package mostafa.algorithms.search;

/**
 * @Author Mostafa
 * On 11/1/22
 */
public class BinarySearch {


    public int search(int[] arr, int value) {
        int mid = arr.length/2;
        while (mid > 0 && mid < arr.length) {
            if(arr[mid] == value) return mid;
            int mid1 = mid/2;
            if(arr[mid1] == value) return mid1;
            int mid2 = (arr.length + mid) / 2;
            if(arr[mid2] == value) return mid2;
        }
        return  -1;

    }
}
