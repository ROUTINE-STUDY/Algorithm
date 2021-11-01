package BaekJoon._17509;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/17509 - And the Winner Is... Ourselves!
 */
public class Sanghoo {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<String> testCaseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputTestCase();
        doCalc();
    }

    private static void doCalc() throws IOException {
        int result = 0;
        int beforeTime = 0;
        int penaltyCnt = 0;

        testCaseList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.valueOf(o1.split(" ")[0]) > Integer.valueOf(o2.split(" ")[0])) return 1;
                else if(Integer.valueOf(o1.split(" ")[0]) < Integer.valueOf(o2.split(" ")[0])) return -1;
                return 0;
            }
        });

        for(String testCase : testCaseList) {
            String[] records = testCase.split(" ");
            int solvingTime = Integer.parseInt(records[0]);
            penaltyCnt += Integer.parseInt(records[1]);

            result += (beforeTime + solvingTime);
            beforeTime += solvingTime;
        }
        result += (20 * penaltyCnt);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void inputTestCase() throws IOException {
        for(int i=0; i<11; i++) {
            testCaseList.add(br.readLine());
        }
        br.close();
    }

}
