package programmers.달리기경주;


import java.util.HashMap;
import java.util.Map;

public class Sanghoo {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution(players, callings);
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String callName : callings) {
            int idx = map.get(callName);

            String temp = players[idx - 1];
            players[idx - 1] = callName;
            players[idx] = temp;

            map.put(callName, idx - 1);
            map.put(temp, idx);
        }

        return players;
        
        /* 시간초과 발생
        for (String call : callings) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].equals(call)) {
                    String temp = players[i - 1];
                    players[i - 1] = players[i];
                    players[i] = temp;
                    break;
                }
            }
        }

        return players;
        */
    }
}
