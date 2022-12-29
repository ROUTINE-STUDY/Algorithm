public class Coke {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;
        int impo = 0;
        int answer = 0;

        while(n >= a){
            impo = n % a + n / a; // 반납 가능한 빈병 수
            n = (n - ( n % a ) - ( n / a )) * b;
            answer += impo;
        }
        System.out.println(answer);

    }
}
