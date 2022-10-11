class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int end = 0;
        
        for (int station : stations) {
            int stationPosition = station - 1;

            end = stationPosition - w - 1;

            if (end < start) {
                end = start;
            } else {
                answer += getBaseStationCntNeeded(start, end, w);
            }

            start = stationPosition + w + 1;
            if (stationPosition + w + 1 >= n) {
                break;
            }
        }

        if (start <= n - 1) {
            answer += getBaseStationCntNeeded(start, n - 1, w);
        }

        return answer;
    }

    private int getBaseStationCntNeeded(int start, int end, int w) {
        int cnt = 0;
        int cntOfUnconnectedCity = end - start + 1;
        cnt += cntOfUnconnectedCity / (w * 2 + 1);
        if (cntOfUnconnectedCity % (w * 2 + 1) != 0) {
            cnt++;
        }

        return cnt;
    }
}
