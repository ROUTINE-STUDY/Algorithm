class Solution {
    //자리 바꾸는 메소드
    public void swap(String[] sArray, int i, int j) {
        String temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
    }

    public String sortSentence(String s) {
        String[] sArray = s.split(" ");
	//버블정렬
        for(int i = 1; i < sArray.length; i++) {
            for(int j = 0; j < sArray.length - i; j++) {
                if(sArray[j].charAt(sArray[j].length()-1) > sArray [j + 1].charAt(sArray[j+1].length()-1)) {
                    swap(sArray, j, j + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String string : sArray) {
            sb.append(string.substring(0, string.length()-1));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
