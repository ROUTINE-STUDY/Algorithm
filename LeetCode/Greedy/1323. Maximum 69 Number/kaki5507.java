class Solution {
    public int maximum69Number (int num) {
        
        StringBuilder snum = new StringBuilder(num+"");
        
        for(int i=0; i<snum.length(); i++){
            if(snum.charAt(i) == '6'){
                snum.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(snum.toString());
    }
}