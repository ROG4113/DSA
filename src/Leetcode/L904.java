package Leetcode;

import java.util.HashMap;

public class L904 {
    public static int totalFruit(int[] fruits) {
        int l=0, r=0, max=0;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        while(r<fruits.length){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            if(map.size()>2){
                map.put(fruits[l], map.getOrDefault(fruits[l], 0)-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=2){
                max=Math.max(max, r-l+1);
            }
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(arr));
    }
}
