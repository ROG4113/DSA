package Leetcode;

public class LetterGreaterThanTagrget {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (char i : letters) {
            if((int)i>(int)target){
                return i;
            }
        }   
        return letters[0];
    }
    public static void main(String[] args) {
        char[] arr={'x', 'x', 'y', 'y'};
        System.out.println(nextGreatestLetter(arr, 'z'));
    }
}
