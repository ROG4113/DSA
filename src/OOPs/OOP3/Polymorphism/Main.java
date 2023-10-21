package OOPs.OOP3.Polymorphism;

public class Main {
    public static void main(String[] args) {
        
        //Here type class is parent but object class is of child, java will call the object which is child class.
        //This is known as UPCASTING and this is how OVERRIDING happens.
        Shapes square = new Square();
        Shapes shape = new Shapes();
        Shapes circle = new Circle();

        square.area();
        shape.area();
        circle.area();
    }
}
