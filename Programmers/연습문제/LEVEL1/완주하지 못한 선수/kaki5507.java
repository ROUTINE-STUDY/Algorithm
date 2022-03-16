import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
         
        HashMap<String, Integer> hs = new HashMap<String,Integer>();
        
        for(String pars : participant){
            hs.put(pars,hs.getOrDefault(pars,0)+1);
        }
        
        for(String comps : completion){
            hs.put(comps,hs.get(comps)-1);
        }
        
        Iterator<Map.Entry<String,Integer>> iter = hs.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}