package OOPs.OOP4;

public class main {
    public static void main(String[] args) {
        access obj = new access(25, "Aniket");
        // need to do a few things:-
        // 1: access the data members.
        // 2: modify the dta members.
        System.out.println(obj.name);
        // System.out.println(obj.num);     // won't work because it's private:-
        System.out.println(obj.GetNum());   // will work as the GetNum can access the num as it's is in same file.

    }
}