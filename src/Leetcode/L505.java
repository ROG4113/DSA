package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class L505 {
    public static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] arr=Arrays.copyOf(score, score.length);
        String[] ans=new String[score.length];
        Arrays.sort(score);
        for(int i= score.length-1; i>=0; i--){
            map.put(score[i], score.length-i);
        }
        for(int i=0; i<score.length; i++){
            int pos=map.get(arr[i]);
            if(pos==1){
                ans[i]="Gold Medal";
            }
            else if(pos==2){
                ans[i]="Silver Medal";
            }
            else if(pos==3){
                ans[i]="Bronze Medal";
            }
            else{
                ans[i]=String.valueOf(pos);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
