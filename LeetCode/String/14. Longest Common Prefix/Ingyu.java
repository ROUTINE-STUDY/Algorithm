class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        String shortestStr = strs[0];

        //제일 짧은 문자열을 구함.
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        //제일 짧은 문자열을 기준으로 다른 문자열과 비교.
        for (int i = 0; i < shortestStr.length(); i++) {
            boolean isAllSame = true;
            char prefixChar = shortestStr.charAt(i);

            for (String str : strs) {
                if (str == shortestStr) {
                    continue;
                }
                if (str.charAt(i) != prefixChar) {
                    isAllSame = false;
                    break;
                }
            }

            //모든 문자열의 i번째 문자가 같지 않으면
            //반복문 빠져나옴.
            //하나라도 틀린 경우, prefix가 될 수 없음.
            if (!isAllSame) {
                break;
            }
            //모든 문자열의 i번째 문자가 같으면
            //문자를 정답에 추가.
            answer.append(prefixChar);
        }

        //정답 리턴.
        return answer.toString();
    }
}