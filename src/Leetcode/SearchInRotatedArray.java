package Leetcode;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int pivot=findPivot(nums);
        if(pivot==-1){
            return BinarySearch(nums, 0, nums.length-1, target);
        }
        if(target==nums[pivot]){
            return pivot;
        }
        if(target>=nums[0]){
            return BinarySearch(nums, 0, pivot-1, target);
        }else{
            return BinarySearch(nums, pivot+1, nums.length-1, target);
        }
    }
    private static int BinarySearch(int[] nums, int start, int end, int target){
            while(start<=end){
                int mid=start+(end-start)/2;
                if(target==nums[mid]){
                    return mid;
                }
                if(target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            return -1;
    }
    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={3,5,1};
        System.out.println(search(arr, 3));
    }
}
