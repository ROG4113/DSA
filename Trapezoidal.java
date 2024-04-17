public class Trapezoidal {
    static double f(double x){
        System.out.println(1/(1+x));
        return 1/(1+x);
    }
    static double Trapezoidal_rule(double a, double b, int n){
        double h = (b-a)/n;
        double sum = f(a)+f(b);

        for(int i = 1; i<n; i++){
            double x = a+i*h;
            sum+= 2*f(x);
        }
        return (h/2*sum);
    }
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 6;
        double result = Trapezoidal_rule(a, b, n);
        System.out.println("Approximate integral: " + result);
    }
}