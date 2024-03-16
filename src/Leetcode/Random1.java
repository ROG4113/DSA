package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Random1 {
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int max=-1;
        for (int i : map.values()) {
            max=Math.max(max, i);
        }
        int count=0;
        for (int freq : map.values()) {
            if(freq==max){
                count+=max;
            }
        }
        return count;
    }
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
            map.put(grid[i][j], map.getOrDefault(grid[i][j], 0)+1);
            }
        }
        System.out.println(map);
        for(int i=1; i<=map.size()+1; i++){
            if(map.getOrDefault(i, 0)>1){
                ans[0]=i;
            }
            if(map.getOrDefault(i, 0)==0){
                ans[1]=i;
            }
        }
        return ans;
    }
    public static int pivotInteger(int n) {
        if(n==0){
            return -1;
        }
        int sum1=0, sum2=n;
        int left=0, right=n;
        while(left<=right){
            if(sum1<sum2){
                sum1+=left++;
            }
            else if(sum2<sum1){
                sum2+=right++;
            }
            else{
                int pivot=(right+left)/2;
                if(pivot!=left && pivot!=right){
                    return pivot;
                }
            }
        }
        return -1;
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1=new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2=new HashMap<Character, Integer>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        System.out.println(map1);
        System.out.println(map2);
        for(int i=0; i<map1.size(); i++){
            if(map1.get(s.charAt(i))!=map2.get(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int max=0;
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            max=Math.max(max, nums[i]);
        }
        int i=1;
        while(i<=max){
            if(!set.contains(i)){
                return i;
            }
            i++;
        }
        return max+1;
    }
    public static int maxProfit(int[] prices) {
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                maxProfit=Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        map.put('c', 12);
        map.put('d', 1);
        map.put('a', 1245);
        map.put('b', 1345);
        // System.out.println(isAnagram("anagram", "nagaram"));
        HashSet<Integer> set=new HashSet<Integer>();
        // System.out.println(firstMissingPositive(arr));
        System.out.println(maxProfit(arr));
    }
}
