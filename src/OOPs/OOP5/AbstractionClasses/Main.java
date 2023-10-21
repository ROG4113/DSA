package OOPs.OOP5.AbstractionClasses;

public class Main{
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();
        // System.out.println(son.age);
        System.out.println(son.value);

        Daughter daughter = new  Daughter(20);
        daughter.career();

        // Parent mom = new Parent();    //You cannot form a object of a parent class.
    }
}