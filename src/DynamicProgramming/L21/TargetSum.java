package DynamicProgramming.L21;

public class TargetSum {
    public static int countTargetSum(int[] arr, int target){
        int[] prev=new int[target+1];
        if(arr[0]==0){
            prev[0]=2;
        }
        else{
            prev[0]=1;
        }
        if(arr[0]!=0 && arr[0]<=target){
            prev[arr[0]]=1;
        }
        for(int i=1; i<arr.length; i++){
            int[] curr=new int[target+1];
            for(int tar=1; tar<=target; tar++){
                int pick=0;
                if(arr[i]<=tar){
                    pick=prev[tar-arr[i]];
                }
                int notPick=prev[tar];
                curr[tar]=pick+notPick;
            }
            prev=curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,1,1,1,1};
        int target=3;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
        }
        if((sum<Math.abs(target) || sum+target<0) || (sum+target)%2!=0){
            return;
        }
        System.out.println(countTargetSum(arr, ((sum+target)/2)));
    }
}
