package BSQuestions;

public class InfiniteArray {
    public static int infinite(int[] nums, int target){
        //cannot use length method
        int s=0, e=1;
        while(target>nums[e]){
            int temp=e+1;
            e=e+(e-s+1)*2;
            s=temp;
        }
        return binarySearch(nums, target, s, e);
    }
    private static int binarySearch(int[] nums, int target, int s, int e){
        while(s<e){
            int m=s+(e-s);
            if(nums[m]<target){
                s=m+1;
            }
            else if(nums[m]>target){
                e=m-1;
            }
            else{
                return m;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,9,12,18,25,29};
        System.out.println(infinite(arr, 18));
    }
}
