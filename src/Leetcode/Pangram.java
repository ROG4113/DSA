package Leetcode;
import java.lang.String;

public class Pangram {
    public static boolean checkIfPangram(String sentence){
        int[] arr=new int[26];
        int len=sentence.length();
        for(int i=0; i<len; i++){
            int index=(int)sentence.charAt(i)-97;
            arr[index]=1;
        }
        for (int j = 0; j < arr.length; j++){
            if(arr[j]==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
