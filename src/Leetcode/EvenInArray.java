package Leetcode;
//Explanation: Return no. of elements having only even digits
public class EvenInArray {
    public static int findNumbers(int[] nums) {
        int count=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp=nums[i];
            while(temp!=0){
                if((temp%10)%2==0){
                    int n=(int)Math.log10(temp)+1;
                    if(n==1){
                        count++;
                    }
                    temp=temp/10;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }

    public static int findNumbers1(int[] nums){
        int count=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp=nums[i];
            int n=(int)Math.log10(temp)+1;
            if(n%2==0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={437,315,322,431,686,264,442};
        System.out.println(findNumbers(arr));
        System.out.println(findNumbers1(arr));
    }

}
