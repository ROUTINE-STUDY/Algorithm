package Programmers.신고결과받기;

import java.util.*;

class User {
    private final Set<String> reports = new HashSet<>();
    private int reportCount;

    public boolean addReportUser(String userId) {
        return reports.add(userId);
    }

    public Set<String> getReports() {
        return reports;
    }

    public void increaseReportCount() {
        reportCount++;
    }

    public int getReportCount() {
        return reportCount;
    }

}

public class Sanghoo {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> userList = new LinkedHashMap<>(); // 순서를 보장하는 LinkedHashMap 사용

        // 유저 생성
        for (String id : id_list) {
            userList.put(id, new User());
        }

        // 유저의 신고목록을 저장 및 신고대상 횟수 증가
        for (String reportStr : report) {
            String[] reportArr = reportStr.split(" ");
            String userId = reportArr[0];
            String target = reportArr[1];

            if(userList.get(userId).addReportUser(target)) { // 중복신고는 불가능
                userList.get(target).increaseReportCount();
            }
        }

        int i = 0;
        for (String key : userList.keySet()) {
            int mailCount = 0;
            User user = userList.get(key);

            if (!user.getReports().isEmpty()) {
                for (String target : user.getReports()) {
                    if (userList.get(target).getReportCount() >= k) { // 유저가 신고한 대상이 k번 이상 신고되었으면 메일 받음
                        mailCount++;
                    }
                }
            }

            answer[i++] = mailCount;
        }

        return answer;
    }
}