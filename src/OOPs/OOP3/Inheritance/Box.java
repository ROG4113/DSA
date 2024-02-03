package OOPs.OOP3.Inheritance;

public class Box {int a = 2;
    double l;
    double h;
    double w;

    Box(){
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }
    //Cube
    Box(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }
    Box(double l, double h, double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }
    
    Box(Box old){
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;  
        }
}
