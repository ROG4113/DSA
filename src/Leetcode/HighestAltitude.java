package Leetcode;

import java.util.Arrays;

public class HighestAltitude {
    public static int largestAltitude(int[] gain) {
        int sum=0;
        int[] arr=new int[gain.length+1];
        for(int i=0; i<gain.length; i++){
            sum+=gain[i];
            arr[i+1]=sum;
        }
        int max=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        } 
        return max;
    }

    public static void main(String[] args) {
        int[] arr={-5,1,5,0,-7};
        int ans=largestAltitude(arr);
        System.out.println(ans);
    }
}
