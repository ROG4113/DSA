package Leetcode;

import java.util.Arrays;

public class StartAndEnd {
    public static int[] searchRange(int[] nums, int target){
        if(nums.length==1 && nums[0]==target){
            return new int[] {0, 0};
        }
        int[] arr=new int[2];
        boolean first=true;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                for (int i = start; i <= end; i++) {
                    if(nums[i]==target && first){
                        arr[0]=i;
                        first=false;
                    }
                    if(i!=nums.length-1){
                        if(nums[i]==target && nums[i+1]!=target){
                            arr[1]=i;
                        }
                    }
                    else{
                        if(nums[i]==target){
                            arr[1]=i;
                        }
                    }
                }
                return arr;
            }
            if(target<nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(Arrays.toString(searchRange(arr, 1)));
    }
}
