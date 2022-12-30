import java.util.Arrays;
import java.util.HashMap;

public class nearStr {
    public static void main(String[] args) {
        String s = "banana";
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> hs = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!hs.containsKey(s.charAt(i))){
                answer[i] = -1;
            }else{
                answer[i] = i - hs.get(s.charAt(i));
            }
            //answer[i] = (!hs.containsKey(s.charAt(i)) ? -1 : i - hs.get(s.charAt(i)));
            hs.put(s.charAt(i),i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
