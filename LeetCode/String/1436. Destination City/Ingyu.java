import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        String answer = null;                   //나갈 곳이 없는 도시.
        Set<String> set = new HashSet<>();      //도시들을 저장할 set.

        for (List<String> path : paths) {       //출발지가 될 수 있는 도시들 저장.
            set.add(path.get(0));
        }

        for (List<String> path : paths) {       //도착지가 될 수 있는 도시들 저장.
            if (set.add(path.get(1))) {         //출발지에 없는 도시가 되면 if문 실행.
                answer = path.get(1);
                break;
            }
        }

        return answer;
    }
}