enum Number {
    zero, one, two, three,
    four, five, six, seven,
    eight, nine;
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (Number number : Number.values())
            s = s.replaceAll(String.valueOf(number), String.valueOf(number.ordinal()));

        return Integer.parseInt(s);
    }
}