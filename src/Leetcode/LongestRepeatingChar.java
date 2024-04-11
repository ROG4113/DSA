package Leetcode;

import java.util.HashMap;

public class LongestRepeatingChar {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int l=0, r=0, maxLen=0, maxFreq=0;
        while(r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxFreq=Math.max(map.get(s.charAt(r)), maxFreq);
            if(r-l+1-maxFreq>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                if(map.getOrDefault(s.charAt(l), 0)==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(r-l+1-maxFreq<=k){
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str="AABABBA";
        System.out.println(characterReplacement(str, 1));
    }
}
