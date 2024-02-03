package Leetcode;

import java.util.Arrays;

public class PlusOne {
    static int[] plus(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        digits=new int[digits.length+1];
        // Arrays.fill(digits, 0);
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        System.out.println(Arrays.toString(plus(digits)));
    }
}
