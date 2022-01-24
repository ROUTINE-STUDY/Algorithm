package BaekJoon.일곱난쟁이_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sanghoo {

    public static void main(String[] args) throws IOException {
        List<Integer> dwarfs = new ArrayList<>();
        int sumOfFakeDwarfs = -100;

        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 + 찾아야하는 키의 합 계산
            for(int i=0; i<9; i++) {
                int height = Integer.parseInt(br.readLine());
                dwarfs.add(height);
                sumOfFakeDwarfs += height;
            }

            // 가짜 난쟁이 2명의 키를 찾자
            int dwarf1 = 0, dwarf2 = 0;
            for(int height : dwarfs) {
                int targetHeight = sumOfFakeDwarfs - height;
                if(dwarfs.indexOf(targetHeight) > 0) {
                    dwarf1 = height;
                    dwarf2 = targetHeight;
                }
            }

            // 지우고 정렬
            dwarfs.remove(Integer.valueOf(dwarf1));
            dwarfs.remove(Integer.valueOf(dwarf2));
            Collections.sort(dwarfs);

            // 출력
            for(int height : dwarfs) {
                System.out.println(height);
            }
        }

    }

}
