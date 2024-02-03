package Recursion.Recursion8;

import java.util.ArrayList;

public class Dice {
    static void dice(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6&&i<=target; i++){
            dice(p+i, target-i);
        }
    }
    //Returning Arraylist
    static ArrayList<String> diceRet(String p, int target){
        ArrayList<String> ans= new ArrayList<>();
        if(target==0){
            ans.add(p);
            return ans;
        }
        for(int i=1; i<=6&&i<=target; i++){
            ans.addAll(diceRet(p+i, target-i));
        }
        return ans;
    }

    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceRet("", 4));
    }
}
