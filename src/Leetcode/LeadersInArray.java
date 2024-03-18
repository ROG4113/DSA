package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=a.length-1; i>=0; i--){
            if(a[i]>max){
                ans.add(a[i]);
                max=a[i];
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={5, 6, 4, 8, 1, 9};
        System.out.println(superiorElements(arr));
    }
}
