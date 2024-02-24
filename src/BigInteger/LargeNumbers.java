package BigInteger;
import java.math.BigInteger;
import java.math.BigDecimal;

public class LargeNumbers {
    public static void main(String[] args) {
        int a=30;
        int b=67;
        BigInteger bi=BigInteger.valueOf(33);
        int A=bi.intValue();
        BigInteger bi1=BigInteger.valueOf(334563847);
        BigInteger bi2=new BigInteger("34875456456456456456645645668");
        BigInteger bi5=new BigInteger("34875456456456456456645645668");
        //constants
        BigInteger bi3=BigInteger.TEN;
        //addition
        BigInteger bi4=bi.add(bi3);
        System.out.println(bi4);
        System.out.println(bi2.multiply(bi5));
        System.out.println(bi2.subtract(bi5));
        System.out.println(bi2.divide(bi5));
        System.out.println(bi2.remainder(bi5));
        BD();
    }
    static void BD(){
        double x=0.04;
        double y=0.03;
        double ans=x-y;
        System.out.println(ans);
        BigDecimal X=new BigDecimal("0.04");
        BigDecimal Y=new BigDecimal("0.03");
        BigDecimal ans1=X.subtract(Y);
        System.out.println(ans1);
        BigDecimal A=new BigDecimal("374563847563847563487.3457638475634");
        BigDecimal B=new BigDecimal("345876348573465873465.53485634875634");
        System.out.println(A.subtract(B));
        System.out.println(A.add(B));
    }
}
