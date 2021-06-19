package Greedy.Water_Bottle;

public class Sanghoo {

    // 몫과 나머지를 이용하자
    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while(numBottles >= numExchange) {
            int changeBottles = numBottles/numExchange;
            result += changeBottles;
            numBottles = changeBottles + (numBottles%numExchange);
        }

        return result;
//        return numBottles + (numBottles-1) / (numExchange-1);
    }

    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

}

