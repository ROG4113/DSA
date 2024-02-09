package Leetcode;

public class sqrt {
    //binary search
    static int sqroot(int x){
        if(x==0||x==1){
            return x;
        }
        int start=0;
        int end=x/2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if((long)mid*mid==(long)x){
                return mid;
            }
            if((long)mid*mid>(long)x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return Math.round(end);
    }
    
    public static void main(String[] args) {
        System.out.println(sqroot(2147395599));
    }
}
