package Leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
    //optimized
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int merge=m+n-1;
        while(index2>=0){
            if(index1>=0 && nums1[index1]>nums2[index2]){
                nums1[merge]=nums1[index1];
                merge--;
                index1--;
            }
            else{
                nums1[merge]=nums2[index2];
                merge--;
                index2--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,0,0,0};
        int[] arr1={2,5,6};
        // merge(arr, 3, arr1, 3);
        merge1(arr, 3, arr1, 3);
    }
}
