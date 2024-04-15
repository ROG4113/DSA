package BSQuestions;

public class CeilingOfNumber{
    public static int ceiling(int[] nums, int target){
        int s=0, e=nums.length-1;
        while(s<e){
            int m=s+(e-s);
            if(nums[m]<target){
                s=m+1;
            }
            else if(nums[m]>target){
                e=m-1;
            }
            else{
                return nums[m];
            }
        }
        //for just greater than target(ceiling) return start, for just less than target return end.
        return nums[e];
    }
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        System.out.println(ceiling(arr, 15));
    }
}