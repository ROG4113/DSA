package Recursion.Recursion6;

import java.util.ArrayList;

public class SubseqASCII {
    static ArrayList<String> seqRetascii(String up, String p){
        ArrayList<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> first=seqRetascii(up.substring(1), p+ch);
        ArrayList<String> second=seqRetascii(up.substring(1), p);
        ArrayList<String> third=seqRetascii(up.substring(1), p+(ch+0));
        first.addAll(second);
        first.addAll(third);
        return first;
    }

    public static void main(String[] args) {
        String str="abc";
        System.out.println(seqRetascii(str, ""));
    }
}
