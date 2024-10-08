package Leetcode;

public class SearchInsertPosition {
    static int insert(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target<nums[mid]){
                end=mid-1;
            }
            if(target>nums[mid]){
                start=mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(insert(arr, 0));
    }
}
