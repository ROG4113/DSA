package Leetcode;

public class L2618 {
    public static int countSeniors(String[] details) {
        int count=0;
        for(String str:details){
            if(Integer.parseInt(str.substring(11, 13))>60) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[] {"7868190130M7522","5303914400F9211","9273338290F4010"} ));
    }
}
