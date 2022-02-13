package BaekJoon.물주기_23351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int result = 0;
            int N = Integer.parseInt(st.nextToken());   // 화분 수
            int K = Integer.parseInt(st.nextToken());   // 기초 수분
            int A = Integer.parseInt(st.nextToken());   // 물을 주는 화분 수
            int B = Integer.parseInt(st.nextToken());   // 물을 준 화분의 수분 증가량

            int[] flowerpots = new int[N];
            for (int i = 0; i < flowerpots.length; i++) {
                flowerpots[i] = K;
            }

            while(true) {
                result++;

                // 1. 랑이 집사가 연속된 A개의 화분에 물을 준다. 이 때 물을 준 화분의 수분은 B만큼씩 증가한다.
                // 가장 수분에 적게 남은 화분에 물을 줘야 기간이 최대한 길어진다.
                Arrays.sort(flowerpots);
                for(int i = 0; i < A; i++) {
                    flowerpots[i] += B-1;
                }

                for (int i = 0; i < flowerpots.length; i++) {
                    flowerpots[i]--;    // 2. 모든 화분의 수분이 1씩 감소한다.

                    // 3. 수분이 0이 된 화분에 있는 캣닢은 죽는다
                    if(flowerpots[i] <= 0) {
                        System.out.println(result);
                        return;
                    }
                }
            }

        }
    }

}
