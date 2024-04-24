package Leetcode;
public class L1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0, r=0, sum=0, count=0;
        for(int i=0; i<k; i++){
            sum+=arr[i];
            r++;
        }
        if(sum/k>=threshold) count++;
        while(r<arr.length){
            sum+=arr[r++];
            sum-=arr[l++];
            if(sum/k>=threshold) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={11,13,17,23,29,31,7,5,2,3};
        System.out.println(numOfSubarrays(arr, 3, 5));
    }
}
