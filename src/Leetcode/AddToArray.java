package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class AddToArray {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans=new LinkedList<Integer>();
        int carry=0, r=num.length-1;
        while(r>=0 || k>0 || carry>0){
            int rem=k%10;
            k=k/10;
            int sum=rem+carry;
            if(r>=0) sum+=num[r--];
            ans.add(0, sum%10);
            carry=sum/10;
        }
        return ans;
    }
    // public static List<Integer> addToArrayForm(int[] num, int k) {
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     long n=0;
    //     for(int i=0; i<num.length; i++){
    //         n=n*10+num[i];
    //     }
    //     n=n+k;
    //     while(n!=0){
    //         long l=n%10;
    //         ans.add(0,(int)l);
    //         n=n/10;
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        int[] arr={1, 2, 0, 0};
        System.out.println(addToArrayForm(arr, 34));
    } 
}
