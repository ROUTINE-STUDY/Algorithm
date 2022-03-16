class Solution {
    public boolean solution(int x) {
        
        String []str = String.valueOf(x).split("");
        
        int hab = 0;
        for(int i=0; i<str.length; i++){
            hab += Integer.parseInt(str[i]);
        }
        
        if(x % hab == 0){
            return true;
        }
        
        return false;
    }
}