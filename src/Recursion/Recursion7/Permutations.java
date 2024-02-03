package Recursion.Recursion7;

import java.util.ArrayList;

public class Permutations {
    static void perm(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            perm(f+ch+s, up.substring(1));
        }
    }
    //Returning Arraylist
    //ArrayListinside the body
    static ArrayList<String> permRet(String p, String up){
        ArrayList<String> ans=new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            ArrayList<String> prev=permRet(f+ch+s, up.substring(1));
            ans.addAll(prev);
        }
        return ans;
    }
    //counting number of permutations
    //variable in arguements
    static int permCount(String p, String up, int count){
        if(up.isEmpty()){
            return count+1;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            permCount(f+ch+s, up.substring(1), count+1);
        }
        return count;
    }
    //variable in body
    static int permCount1(String p, String up){
        int count=0;
        if(up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            count+=permCount1(f+ch+s, up.substring(1));
        }
        return count;
    }
    public static void main(String[] args) {
        String str="abc";
        // perm("", str);
        // System.out.println(permRet("", str));
        System.out.println(permCount("", str, 0));
        System.out.println(permCount1("", str));
    }
}
