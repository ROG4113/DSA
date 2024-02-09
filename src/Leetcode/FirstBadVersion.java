package Leetcode;

public class FirstBadVersion {
    public static int firstBadVersion(int n, boolean[] arr) {
        if(n<2){
            return n;
        }
        int start=0;
        int end=n;
        while(start<=end){
            int version=start+(end-start)/2;
            boolean isBad=arr[version];
            if(arr[version]==true&&arr[version-1]==false){
                return version;
            }
            if(isBad){
                end=version-1;
            }
            else{
                start=version+1;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        boolean[] arr={false, false, false, false, true, true};
        System.out.println(firstBadVersion(2, arr));
    } 
}
