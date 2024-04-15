package BSQuestions;

public class MountainArray {
    public static int bitonic(int[] nums){
        int pivot=pivot(nums);
        return pivot;
    }
    private static int pivot(int[] nums) {
        int s=0, e=nums.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(nums[m]<nums[m+1]){
                s=m+1;
            }
            else if(nums[m]>nums[m+1]){
                e=m;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,4,3,2};
        System.out.println(bitonic(arr));
    }
}
