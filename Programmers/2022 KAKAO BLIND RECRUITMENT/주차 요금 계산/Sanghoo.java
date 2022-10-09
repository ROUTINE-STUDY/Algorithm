package Programmers.주차요금계산;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Bill {
    private List<LocalTime> inTimeList = new ArrayList<>();
    private List<LocalTime> outTimeList = new ArrayList<>();
    private double price;
    private final double DEFAULT_MINUTE;
    private final double DEFAULT_PRICE;
    private final double UNIT_MINUTE;
    private final double UNIT_PRICE;

    public Bill(String record, int[] fees) {
        DEFAULT_MINUTE = fees[0];
        DEFAULT_PRICE = fees[1];
        UNIT_MINUTE = fees[2];
        UNIT_PRICE = fees[3];

        addAccessRecords(record);
    }
    // 기록 저장
    public void addAccessRecords(String record) {
        String[] info = record.split(" ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm");
        String recordTime = info[0];

        if ("IN".equals(info[2])) {
            inTimeList.add(LocalTime.parse(recordTime, dateTimeFormatter));
        } else {
            outTimeList.add(LocalTime.parse(recordTime, dateTimeFormatter));
        }
    }
    // 요금 계산
    public void calcPrice(int[] fees) {
        int totalMinute = 0;

        for (int i = 0; i < inTimeList.size(); i++) {
            LocalTime inTime = inTimeList.get(i);
            LocalTime outTime;

            try {
                outTime = outTimeList.get(i);
            } catch (IndexOutOfBoundsException e) {
                outTime = LocalTime.of(23, 59);
            }

            totalMinute += Duration.between(inTime, outTime).getSeconds() / 60;
        }

        price = totalMinute > DEFAULT_MINUTE ? DEFAULT_PRICE + Math.ceil((totalMinute - DEFAULT_MINUTE) / UNIT_MINUTE) * UNIT_PRICE : DEFAULT_PRICE;
    }

    public double getPrice() {
        return price;
    }
}

public class Sanghoo {

    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };

        solution(fees, records);

    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Bill> billsMap = new HashMap<>();

        for (String record : records) { // 출입 기록 저장
            String[] info = record.split(" ");
            String carNumber = info[1];

            Bill bill = billsMap.get(carNumber);
            if (bill == null) {
                billsMap.put(carNumber, new Bill(record, fees));
            } else {
                bill.addAccessRecords(record);
            }
        }

        for (Bill bill : billsMap.values()) { // 요금 계산
            bill.calcPrice(fees);
        }
        // 차 번호로 정렬 후 결과 세팅
        ArrayList<String> keySet = new ArrayList<>(billsMap.keySet());
        answer = new int[keySet.size()];

        Collections.sort(keySet);
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = (int) billsMap.get(keySet.get(i)).getPrice();
        }

        return answer;
    }

}
