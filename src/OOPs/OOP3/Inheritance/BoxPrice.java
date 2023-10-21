package OOPs.OOP3.Inheritance;

public class BoxPrice extends Boxweight{
    double price;

    BoxPrice(){
        this.price = -1;
    }
    BoxPrice(double l, double w, double h, double weight, double price){
        super(l, w, h, weight);
        this.price = price; 
    }
}
