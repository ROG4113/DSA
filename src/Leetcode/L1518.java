package Leetcode;

public class L1518{
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count=0, empty=0;
        while(numBottles>0 || empty>=numExchange){
            count+=numBottles;
            empty+=numBottles%numExchange;
            numBottles/=numExchange;
            if(empty>=numExchange){
                numBottles+=empty/numExchange;
                empty=empty%numExchange;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numWaterBottles(100, 2));
    }
}