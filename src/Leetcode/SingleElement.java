package Leetcode;

public class SingleElement {
    public static int single(int[] nums){
        if(nums.length%2==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int start=0;
        int end=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            //if first is single
            if(mid==0){
                return nums[0];
            }
            //if last is single
            if(mid==nums.length-1){
                return nums[nums.length-1];
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    start=mid+1;
                }
                else if(nums[mid]==nums[mid-1]){
                    end=mid-1;
                }
                else{
                    return nums[mid];
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){
                    end=mid-1;
                }
                else if(nums[mid]==nums[mid-1]){
                    start=mid+1;
                }
                else{
                    return nums[mid];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1, 1, 2, 2, 3, 3, 4, 4, 8};
        System.out.println(single(arr));
    }
}
