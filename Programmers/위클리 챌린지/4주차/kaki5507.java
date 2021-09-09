import java.util.*;

class Solution {
    public String solution(String[] tb, String[] langs, int[] pre) {
        int big = 0;
		String answer = "";
		HashMap<String,Integer> map = new HashMap();
		
		for(int i=0; i<tb.length; i++) {
			String[] tmp = tb[i].split(" ");
			
			for(int j=1; j<6; j++) {
				
				int gasan=0;
				int score=0;
				
				for(int k=0; k<langs.length; k++) {
					if(tmp[j].equals(langs[k])) {
						gasan = pre[k];
					}
				}
				score = gasan * (6-j);
                
				map.put(tmp[0],map.getOrDefault(tmp[0], 0) + score);
			}
			
            
			if(map.get(tmp[0]) > big) {
				big = map.get(tmp[0]);
				answer = tmp[0];
			}else if(map.get(tmp[0]) == big) {
				if(answer.compareTo(tmp[0]) > 0) {
					big = map.get(tmp[0]);
					answer = tmp[0];
				};
			}
		}

		return answer;
    }
}