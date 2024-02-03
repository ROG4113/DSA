package Recursion.Recursion8;

import java.util.ArrayList;

public class PhoneNumber {
    static void phone(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char) ('a'+i);
            phone(p+ch, up.substring(1));
        }
    }
    //Returning arraylist of String
    //list inside the body
    static ArrayList<String> phoneRet(String p, String up){
        ArrayList<String> ans=new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char) ('a'+i);
            ans.addAll(phoneRet(p+ch, up.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {
        phone("", "12");
        System.out.println(phoneRet("", "12"));
    }
}
