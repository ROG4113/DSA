package Recursion.Recursion4;

import java.util.Arrays;

public class SelectionSort {
    static void selection(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c+1, c);
            }
            else{
                selection(arr, r, c + 1, max);
            }
        } else {
            // swap
            int temp = arr[r-1];
            arr[r-1] = arr[max];
            arr[max] = temp;
            selection(arr, r - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 3, 8, 2};
        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
}
