class Solution {
    public int maximum69Number (int num) {
        
        StringBuilder snum = new StringBuilder(num+""); //num�� ���ڿ��� ��ȯ
        
        for(int i=0; i<snum.length(); i++){
            if(snum.charAt(i) == '6'){ 
                snum.setCharAt(i,'9'); //setCharAt �ٲ���.
                break;
            }
        }
        return Integer.parseInt(snum.toString());
    }
}