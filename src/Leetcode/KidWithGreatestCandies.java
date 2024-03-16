package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidWithGreatestCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans=new ArrayList<>();
        int max=0;
        for(int n:candies){
            if(max<n){
                max=n;
            }
        }
        for (int i = 0; i < candies.length; i++) {
                if(candies[i]+extraCandies>=max){
                    ans.add(true);
                }
                else{
                    ans.add(false);
                }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={2,3,5,1,3};
        System.out.println(kidsWithCandies(arr, 3));
    }
}
