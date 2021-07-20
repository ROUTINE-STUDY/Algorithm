class Solution {
    public int maximum69Number (int num) {
        
        StringBuilder snum = new StringBuilder(num+""); //num을 문자열로 변환
        
        for(int i=0; i<snum.length(); i++){
            if(snum.charAt(i) == '6'){ 
                snum.setCharAt(i,'9'); //setCharAt 바꿔줌.
                break;
            }
        }
        return Integer.parseInt(snum.toString());
    }
}