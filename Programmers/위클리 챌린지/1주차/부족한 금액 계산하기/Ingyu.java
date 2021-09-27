class Solution {
    public long solution(int price, int money, int count) {
        long total = (count * (count + 1))/2;
        total *= price;

        if (money - total >= 0) return 0;
        return total - money;
    }
}