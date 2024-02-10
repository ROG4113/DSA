package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddToArray {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        long n=0;
        for(int i=0; i<num.length; i++){
            n=n*10+num[i];
        }
        n=n+k;
        while(n!=0){
            long l=n%10;
            ans.add(0,(int)l);
            n=n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,9,9,9,9,9,9,9,9,9,9};
        System.out.println(addToArrayForm(arr, 1));
    } 
}
