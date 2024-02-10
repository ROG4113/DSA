package Leetcode;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return helper(nums, target, start, end);
    }

    private static int helper(int[] nums, int target, int start, int end) {
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                return helper(nums, target, start, mid-1);
            }
            else{
                return helper(nums, target, mid+1, end);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={-1,0,3,5,9,12};
        System.out.println(search(arr, 12));
    }
}
