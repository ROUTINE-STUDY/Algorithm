package Programmers.야간전술보행;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Guards {
    static class Guard {
        private int[] scope;
        private int[] times;
        private Queue<String> workList = new ArrayDeque<>();
        private boolean isWatch;

        public Guard(int[] scope, int[] times) {
            this.scope = scope;
            this.times = times;

            for (int i = 0; i < times.length; i++) {
                String status = i == 0 ? "WORK" : "REST";
                for (int j = 0; j < times[i]; j++) {
                    workList.add(status);
                }
            }
        }

        public void writeWorkList() {
            for (int i = 0; i < times.length; i++) {
                String status = i == 0 ? "WORK" : "REST";
                for (int j = 0; j < times[i]; j++) {
                    workList.add(status);
                }
            }
        }
    }

    List<Guard> guardList = new ArrayList<>();

    /**
     * 경비병 추가
     */
    public void addGuard(int[][] scope, int[][] times) {
        for (int i = 0; i < scope.length; i++) {
            guardList.add(new Guard(scope[i], times[i]));
        }
    }

    /**
     * 경비병 상태 수정
     */
    public void moveGuard() {
        for (Guard guard : guardList) {
            if (guard.workList.isEmpty()) {
                guard.writeWorkList();
            }
            String status = guard.workList.poll();
            guard.isWatch = "WORK".equals(status);
        }
    }

    /**
     * 현재 거리에 경비병이 근무중인지 확인하는 메서드
     */
    public boolean checkGuard(int distinct) {
        for (Guard guard : guardList) {
            if (guard.isWatch) {
                int scopeStart = guard.scope[0];
                int scopeEnd = guard.scope[1];

                if ((scopeStart <= distinct && scopeEnd >= distinct) || (scopeEnd <= distinct && scopeStart >= distinct)) {
                    return true;
                }
            }
        }

        return false;
    }

}

public class Sanghoo {

    public static void main(String[] args) {
//        solution(10, new int[][]{{3, 4}, {5, 8}}, new int[][]{{2, 5}, {4, 3}});
        solution(12, new int[][]{{7, 8}, {4, 6}, {11, 10}}, new int[][]{{2, 2}, {2, 4}, {3, 3}});
    }

    public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;

        Guards guards = new Guards();
        guards.addGuard(scope, times);

        while (answer < distance) {
            answer++;
            guards.moveGuard();

            if (guards.checkGuard(answer)) {
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }

}
