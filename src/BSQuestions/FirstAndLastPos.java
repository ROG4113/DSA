package BSQuestions;

import java.util.Arrays;

public class FirstAndLastPos{
    public static int[] position(int[] nums, int target){
        int[] ans=new int[2];
        ans[0]=search(nums, target, true);        
        ans[1]=search(nums, target, false);
        return ans;
    }
    private static int search(int[] nums, int target, boolean first){
        int ans=-1;
        int s=0, e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]<target){
                s=m+1;
            }
            else if(nums[m]>target){
                e=m-1;
            }
            else{
                ans=m;
                if(first){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        System.out.println(Arrays.toString(position(arr, 8)));
    }
}