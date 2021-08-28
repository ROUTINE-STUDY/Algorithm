package Programmers;

import java.util.*;

public class Sanghoo {

    public String solution(String[]  table, String[] languages, int[] preference) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>(); // 언어와 선호도 점수를 담는 맵

        // 한 row 씩 반복
        // 직업군     | 언어들
        // "SI       | JAVA       JAVASCRIPT SQL    PYTHON C#"
        // "CONTENTS | JAVASCRIPT JAVA       PYTHON SQL    C++"
        // "HARDWARE | C          C++        PYTHON JAVA   JAVASCRIPT"
        for(String row : table) {
            // String 형식의 row를 공백으로 나누어 배열에 저장
            String[] rowArr = row.split(" ");
            int score = 0;
            int checkScore = 5;
            map.put(rowArr[0], 0);  // map에 언어이름과 점수 초기값 세팅

            // 5점부터 각 직업군별 언어들을 계산
            for(int i=1; i<rowArr.length; i++) {
                String lang = rowArr[i];
                score += (checkScore-- * getPreference(languages, preference, lang));
            }
            // 계산된 값 저장
            map.put(rowArr[0], score);
        }

        answer = getHighJob(map);
        return answer;
    }

    // 언어의 선호도 점수를 가져오는 메서드
    public int getPreference(String[] languages, int[] preference, String findLang) {
        int findPreference = 0;

        for(int i=0; i<languages.length; i++) {
            if(languages[i].equals(findLang)) {
                findPreference = preference[i];
                break;
            }
        }
        return findPreference;
    }

    // 가장 높은 점수의 직업군을 반환하는 메서드
    public String getHighJob(Map<String, Integer> map) {
        Iterator iter = map.entrySet().iterator();
        String highJob = "";
        int max = 0;

        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();
            int totalScore = entry.getValue();

            if(max < totalScore) {
                max = totalScore;
                highJob = entry.getKey();
            } else if(max == totalScore){
                // 동일한 점수면 사전순
                String[] arr = {highJob, entry.getKey()};
                Arrays.sort(arr);
                highJob = arr[0];
            }
        }

        return highJob;
    }
}
