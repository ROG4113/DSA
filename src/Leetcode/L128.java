package Leetcode;

import java.util.HashSet;

public class L128 {
    public static int longestConsecutive(int[] nums) {
        int count=0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            int left=i-1;
            int right=i+1;
            while(set.remove(left)){
                left--;
            }
            while(set.remove(right)){
                right++;
            }
            count=Math.max(count, right-left-1);
            if(set.isEmpty()) return count; 
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }
}
