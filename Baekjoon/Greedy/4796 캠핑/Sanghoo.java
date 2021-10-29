package BaekJoon.캠핑_4796;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sanghoo {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<String> testCaseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputTestCase();
        doCalc();
    }

    private static void doCalc() throws IOException {
        for(int i = 0; i<testCaseList.size(); i++) {
            String[] LPV = testCaseList.get(i).split(" ");
            int L = Integer.parseInt(LPV[0]);
            int P = Integer.parseInt(LPV[1]);
            int V = Integer.parseInt(LPV[2]);
            int resultDay = 0;

            int continueDay = V/P;
            resultDay += L * continueDay;

            int remainingDays = V - (P * continueDay); //= V%P
            resultDay += Math.min(L, remainingDays);

            bw.write("Case " + (i+1) + ": " + resultDay);
            bw.newLine();
        }
        bw.flush();
    }

    private static void inputTestCase() throws IOException {
        while(true) {
            String inputLPV = br.readLine();
            if("0 0 0".equals(inputLPV)) { break; }
            testCaseList.add(inputLPV);
        }
        br.close();
    }

}
