import java.util.Arrays;

class Solution {
    public String sortSentence(String s) {
        //띄어쓰기로 각 문장을 나눈 배열을 만듭니다.
        String[] sArray = s.split(" ");
        //정렬하여 넣을 문자열 배열을 만듭니다.
        String[] sortedArray = new String[sArray.length];

        //문자열의 각 끝의 숫자를 뽑아 그 숫자 -1을 한(주어진 문자열의 첫번째가 1부터 시작이므로 1을 빼야함) 인덱스의 문자열을 넣습니다.
        for (int i = 0; i < sArray.length; i++) {
            int index = sArray[i].charAt(sArray[i].length()-1) - '1';
            sortedArray[index] = sArray[i];
        }

        //숫자 제외하고 넣습니다.
        StringBuilder sb = new StringBuilder();
        for (String string : sortedArray) {
            sb.append(string.substring(0, string.length()-1));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}