import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// int 타입은 Integer 타입 배열로 변경해줘야 역순 출력 가능
// int : 자료형 , 산술 연산 가능 , null로 초기화 불가능
// Integer : 래퍼 클래스 , Unboxing하지 않을 경우 연산 불가 , null 값 가능
public class FruitDealer {
    public static void main(String[] args) {
        int k = 4, m = 3;
        int[] score = {4,1,2,2,4,4,4,4,1,2,4,2};
        /*
        boxed() 메소드는 intStream 같이 원시 타입 즉 자료형으로 전환하여 실행 가능하게 하는 함수
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreArr, Collections.reverseOrder());
        */
        int answer = 0;
        int box = score.length/m;
        int minScore = 0;
        Arrays.sort(score);
        System.out.println(Arrays.toString(score));
        System.out.println("박스 개수 : " + box);
        for(int i=1; i<=box; i++){ // 현재 박스 갯수 4개
            minScore = score.length - (m*i);
            System.out.println("제일 작은 사과의 점수 : " + minScore);
            answer += score[minScore] * m;
        }
        System.out.println(answer);
    }
}
