package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddToArray {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=0;
        for(int i=0; i<num.length; i++){
            n=n*10+num[i];
        }
        n=n+k;
        while(n!=0){
            ans.add(0,n%10);
            n=n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={9,9,9,9,9,9,9};
        System.out.println(addToArrayForm(arr, 1));
    } 
}
