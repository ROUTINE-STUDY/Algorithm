package String.Destination_City;

import java.util.List;

/**
 * https://leetcode.com/problems/destination-city/
 */
public class Sanghoo {

    // 목적지는 어떠한 경로의 첫 번째 도시가 될 수 없음을 이용
    public String destCity(List<List<String>> paths) {
        String res = "";
        StringBuilder firstCitys = new StringBuilder();

        // 첫 번째 도시 세팅
        for(List<String> path : paths) {
            String firstCity = path.get(0);
            firstCitys = firstCitys.append(firstCity);
        }

        // 두 번째 도시들 중 첫 번째 도시에 해당하지 않는 도시 찾기
        for(List<String> path : paths) {
            String lastCity = path.get(1);

            if(firstCitys.indexOf(lastCity) < 0) {
                res = lastCity;
                break;
            }
        }

        return res;
    }

}
