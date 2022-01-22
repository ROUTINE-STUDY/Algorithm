import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HwangInGyu {
    static final int cntOfPeople = 9;
    static final int cntOfDwarfs = 7;
    static final int maxLength = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 존재하는 높이인지 확인
        boolean[] isExistHeights = new boolean[maxLength+1];
        // 모든 생명체의 키
        int[] heightOfPeople = new int[cntOfPeople];
        // 가짜 드워프의 키
        int[] heightOfFalseDwarf = new int[cntOfPeople-cntOfDwarfs];
        // 현재 모든 생명체의 키의 총합
        int currentSumOfHeight = 0;
        for (int i = 0; i < cntOfPeople; i++) {
            int height = Integer.parseInt(br.readLine());
            heightOfPeople[i] = height;
            currentSumOfHeight += height;
            isExistHeights[height] = true;
        }

        // 가짜 드워프의 키를 구함.
        heightOfFalseDwarf = getFalseDwarfsIndex(heightOfPeople, heightOfFalseDwarf,currentSumOfHeight, 0, 0);
        if (heightOfFalseDwarf != null) {
            for (int i = 0; i < heightOfFalseDwarf.length; i++) {
                isExistHeights[heightOfFalseDwarf[i]] = false;
            }
            for (int i = 0; i < isExistHeights.length; i++) {
                if (isExistHeights[i]) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    // 가짜 드워프들의 키를 반환하는 메서드
    private static int[] getFalseDwarfsIndex(int[] heightOfPeople, int[] heightOfFalseDwarf, int currentSumOfHeight,int cntOfCurrentFalseDwarf, int idxOfPeople) {
        if (cntOfCurrentFalseDwarf == cntOfPeople-cntOfDwarfs) {
            if (currentSumOfHeight == 100) {
                return heightOfFalseDwarf;
            }
            return null;
        }
        if (idxOfPeople == cntOfPeople) {
            return null;
        }

        currentSumOfHeight -= heightOfPeople[idxOfPeople];
        heightOfFalseDwarf[cntOfCurrentFalseDwarf] = heightOfPeople[idxOfPeople];
        int[] answer = getFalseDwarfsIndex(heightOfPeople, heightOfFalseDwarf, currentSumOfHeight, cntOfCurrentFalseDwarf+1, idxOfPeople+1);
        if (answer != null) {
            return answer;
        }
        currentSumOfHeight += heightOfPeople[idxOfPeople];
        heightOfFalseDwarf[cntOfCurrentFalseDwarf] = 0;
        answer = getFalseDwarfsIndex(heightOfPeople, heightOfFalseDwarf, currentSumOfHeight, cntOfCurrentFalseDwarf, idxOfPeople+1);
        if (answer != null) {
            return answer;
        }

        return null;
    }
}