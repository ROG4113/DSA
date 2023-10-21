package OOPs.OOP5.AbstractionClasses;

public class Daughter extends Parent {

    public Daughter(int age){
        super(age);
    }

    @Override
    void career(){
        System.out.println("I am going to be Coder");
    }
    @Override
    void partner(){
        System.out.println("I love Harry potter");
    }
}
