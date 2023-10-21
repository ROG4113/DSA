package OOPs.OOP5.AbstractionClasses;

public abstract class Parent {

    public Parent(int age){
        this.age = age;
        value = 5645;
    }

    final int value;
    int age;
    abstract void career();
    abstract void partner();
}
