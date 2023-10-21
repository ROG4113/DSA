package OOPs.OOP3.Inheritance;

public class Main {
    public static void main(String[] args){
        Box box = new Box();
        System.out.println(box.l + " " + box.h + " " + box.w);
        Box box1 = new Box(10);
        System.out.println(box1.l + " " + box1.h + " " + box1.w);
        Box box2 = new Box(2.5, 4.2, 3.5);
        System.out.println(box2.l + " " + box2.h + " " + box2.w);
        Box box3 = new Box(box);
        System.out.println(box3.l + " " + box3.h + " " + box3.w);

        Boxweight box4 = new Boxweight();
        System.out.println(box4.weight + " " + box4.l);
        Boxweight box5 = new Boxweight(10, 32, 45, 34);
        System.out.println(box5.l + " " + box5.h + " " + box5.w + " " + box5.weight);

        BoxPrice box6 = new BoxPrice(12, 51, 15, 28, 36);
        System.out.println(box6.l + " " + box6.h + " " + box6.w + " " + box6.weight + " " + box6.price); 
    }
}
