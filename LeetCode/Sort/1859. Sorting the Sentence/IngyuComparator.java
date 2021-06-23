import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String sortSentence(String s) {
        //띄어쓰기로 각 문장을 나눈 배열을 만듭니다.
        String[] sArray = s.split(" ");
        //Comparator 익명 클래스를 구현하여, 맨 뒤에 숫자를 기준으로 문자배열을 정렬합니다.
        Arrays.sort(sArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(o1.length()-1) > o2.charAt(o2.length()-1)) {
                    return 1;
                } else if (o1.charAt(o1.length()-1) < o2.charAt(o2.length()-1)) {
                    return -1;
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        //반복해서 각 문자열을 숫자를 빼서 잘라서 StringBuilder에 붙입니다(append).
        for (String string : sArray) {
            sb.append(string.substring(0, string.length()-1));
            sb.append(" ");
        }
        //마지막에 한번 더 공백이 들어가므로 마지막 문자를 지워줍니다.
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}