package StringBuffer;

import java.util.Arrays;

import java.text.DecimalFormat;

public class StrBuffer {
    public static void main(String[] args) {
        // constructor 1
        StringBuffer sb=new StringBuffer();
        System.out.println(sb.capacity());
        // constructor 2
        StringBuffer sb1=new StringBuffer("Aniket Singh");
        System.out.println(sb1.capacity());
        // constructor 3
        StringBuffer sb2=new StringBuffer(30);
        System.out.println(sb2.capacity());
        sb.append("WeMakeDevs");
        sb.append(" is nice!");
        sb.insert(2, " Aniket ");
        sb.replace(3, 10, " Singh ");
        sb.delete(3, 10);
        System.out.println(sb);
        RandomString str=new RandomString();
        int n=20;
        String name=str.generate(n);
        System.out.println(name);
        //removing whitespaces
        String sentence="My name is Aniket Singh.";
        System.out.println(sentence.replaceAll(" ", ""));
        //split
        String arr="Aniket Anshika Chaitanya Himanshu";
        String[] names=arr.split(" ");
        System.out.println(Arrays.toString(names));
        //rounding off
        DecimalFormat df=new DecimalFormat("00.00000000");
        System.out.println(df.format(7.29));
        System.out.println(arr.contains("z"));
    }
}
