package OOPs.OOP3.Polymorphism;

public class Shapes{
    //if we out final keyword for ex- "final void area()" then this will not get override
    //in any of the child class. It improves performance as the compiler will know that
    //it won't get override.
    void area(){
        System.out.println("I am in shapes!");
    }
}
