package programmers.데이터분석;

import java.util.ArrayList;
import java.util.List;

// 데이터 객체
class Data {
    int code;
    int date;
    int maximum;
    int remain;

    public Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }

    // 어떠한 값으로 정렬할 지 판단하기 위한 메서드
    public int getSortby(String sort_by) {
        switch (sort_by) {
            case "code":
                return this.code;
            case "date":
                return this.date;
            case "maximum":
                return this.maximum;
            default:
                return this.remain;
        }
    }
}

// 배열의 index 값과 의미를 저장한 enum
enum DataSet {
    CODE(0), DATE(1), MAXIMUM(2), REMAIN(3);

    private final int value;

    DataSet(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Sanghoo {

    public static void main(String[] args) {
        int[][] arr = {{1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}};

        solution(arr, "date", 20300501, "remain");
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int value = DataSet.valueOf(ext.toUpperCase()).getValue(); // enum을 통해 기준이 배열의 몇 번째인지 확인
        List<Data> list = new ArrayList<>();

        for (int[] d : data) {
            if (d[value] > val_ext) {
                continue;
            }
            Data obj = new Data(d[0], d[1], d[2], d[3]);
            list.add(obj);
        }

        list.sort((o1, o2) -> o1.getSortby(sort_by) - o2.getSortby(sort_by));

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            Data obj = list.get(i);
            answer[i][0] = obj.code;
            answer[i][1] = obj.date;
            answer[i][2] = obj.maximum;
            answer[i][3] = obj.remain;
        }

        return answer;
    }

}
