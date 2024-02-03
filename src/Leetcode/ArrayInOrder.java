package Leetcode;

import java.util.Arrays;

public class ArrayInOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for(int k=0; k<target.length; k++){
            target[k]=-1;
        }
        for (int i = 0; i < target.length; i++){
            if(target[index[i]]!=-1){
                for(int j=target.length-1; j>index[i]; j--){
                    target[j]=target[j-1];
                }
            }
            target[index[i]] = nums[i];
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums={0,1,0};
        int[] index={0,1,0};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}
