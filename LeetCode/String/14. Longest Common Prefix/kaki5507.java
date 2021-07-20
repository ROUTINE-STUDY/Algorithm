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
    1. ���ڹ迭�� ������ ������ �����մϴ�.
    2. ù ��° ���� �̿��ؼ� ���� ������ ���� ���� ���ڿ��� �����ݴϴ�.
    3. ab / a ���� ��� if���� ��Ÿ�� �ǹǷ� a �� ������ ���� ������ ���ݴϴ�.
    4. j�� ������ �� ���� ���ڿ� ���� �����ϰ� ���ݴϴ�.
*/