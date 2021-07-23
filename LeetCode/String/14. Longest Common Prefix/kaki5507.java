class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){return "";}
        Arrays.sort(strs);
        String first = strs[0];
        
        for(int i=1; i<strs.length; i++){
            for(int j=0; j<Math.min(first.length(), strs[i].length()); j++){
                if(strs[i].charAt(j) != first.charAt(j)){
                	first = strs[i].substring(0, j);
                }
            }
        }
        return first;
    }
}
/*
    1. 문자배열이 없으면 공백을 리턴합니다.
    2. 첫 번째 값을 이용해서 버블 정렬을 통해 각각 문자열을 비교해줍니다.
    3. ab / a 같은 경우 if문을 안타게 되므로 a 가 앞으로 오게 정렬을 해줍니다.
    4. j의 조건을 더 작은 문자열 까지 진행하게 해줍니다.
*/