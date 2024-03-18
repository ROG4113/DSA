package Leetcode;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index=-1, minindex=0;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            rev(nums, 0, nums.length-1);
            return;
        }
        int minimum=Integer.MAX_VALUE;
        for(int i=index+1; i<nums.length; i++){
            if(nums[i]>nums[index] && nums[i]<=minimum){
                minindex=i;
            }
            minimum=Math.min(minimum, nums[i]);
        }
        //swap
        swap(nums, index, minindex);
        //rev
        rev(nums, index+1, nums.length-1);
    }
    private static void rev(int[] nums, int i, int j) {
        int start=i, end=j;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    private static void swap(int[] nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,3,3};
        nextPermutation(arr);
    }
}
