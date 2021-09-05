import java.util.*;
class Ingyu {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String,Map<String, Integer>> database = new HashMap<>();
        for (String company : table) {
            int score = 5;
            String[] sArray = company.split(" ");
            Map<String, Integer> tempMap = new HashMap();
            for (int i = 1; i < sArray.length; i++) {
                tempMap.put(sArray[i], score--);
            }
            database.put(sArray[0],tempMap);
        }

        Map<String, Integer> jobScoreMap = new HashMap<>();
        for (String key : database.keySet()) {
            Map<String,Integer> tempMap = database.get(key);
            int totalScore = 0;
            for (int i = 0; i < languages.length; i++) {
                totalScore += tempMap.getOrDefault(languages[i],0) * (preference[i]);
            }

            jobScoreMap.put(key, totalScore);
        }

        int max = 0;
        for (int score : jobScoreMap.values()) {
            if (score > max) {
                max = score;
            }
        }

        List<String> highPointJob = new ArrayList<>();
        for (String job : jobScoreMap.keySet()) {
            if (jobScoreMap.get(job) == max) highPointJob.add(job);
        }

        Collections.sort(highPointJob);
        return highPointJob.get(0);
    }
}