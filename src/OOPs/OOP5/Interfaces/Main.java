package OOPs.OOP5.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.acc();
        car.brake();
        car.stop();

        Media carMedia = new Car();
        carMedia.stop();
    }
}
