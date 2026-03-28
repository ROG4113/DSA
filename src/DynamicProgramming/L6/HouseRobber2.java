package DynamicProgramming.L6;

public class HouseRobber2 {
    // houses are arrange in circular manner, and adjacent houses has alarms
    public static int rob(int[] arr, int start, int end){
        int prev=arr[start];
        int prev2=0;
        for(int i=start+1; i<=end; i++){
            int pick=arr[i];
            if(i>start+1){
                pick+=prev2;
            }
            int notPick=0+prev;
            prev2=prev;
            prev=Math.max(pick, notPick);
        }
        return prev;
    }
    public static void main(String[] args){
        int[] nums=new int[]{2,3,2}; // test cases: 1,2,3 || 1,2,3,1
        int leaveFirst=rob(nums, 1, nums.length-1);
        int leaveLast=rob(nums, 0, nums.length-2);
        System.out.println(leaveFirst + " " + leaveLast);
        System.out.println(Math.max(leaveFirst, leaveLast));
    }
}
