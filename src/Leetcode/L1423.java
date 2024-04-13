package Leetcode;
public class L1423{
    public static int maxScore(int[] cardPoints, int k) {
        int lsum=0, rsum=0;
        for(int i=0; i<k; i++){
            lsum+=cardPoints[i];
        }
        int maxSum=lsum;
        int r=cardPoints.length-1;
        for(int i=k-1; i>=0; i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[r];
            maxSum=Math.max(maxSum, lsum+rsum);
            r--;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr={96,90,41,82,39,74,64,50,30};
        System.out.println(maxScore(arr, 8));
    }
}