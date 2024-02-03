package Recursion.Recursion6;

import java.util.ArrayList;

public class Subseq {
    static void seq(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        seq(up.substring(1), p+ch);
        seq(up.substring(1), p);
    }
    //return the arraylist of string
    //list inside the body :)
    static ArrayList<String> seq1(String up, String p){
        ArrayList<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=seq1(up.substring(1), p+ch);
        ArrayList<String> right=seq1(up.substring(1), p);
        left.addAll(right);
        return left;
    }
    public static void main(String[] args) {
        String str="abc";
        // seq1(str, "");
        System.out.println(seq1(str, ""));
    }
}
