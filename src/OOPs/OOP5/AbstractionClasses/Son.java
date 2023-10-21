package OOPs.OOP5.AbstractionClasses;

public class Son extends Parent{

    public Son(int age){
        super(age);
    }

    @Override
    void career(){
        System.out.println("I will be a Doctor");
    }
    @Override
    void partner(){
        System.out.println("I love Spiderman");
    }
}
