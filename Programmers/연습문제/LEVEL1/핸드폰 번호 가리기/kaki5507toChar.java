class Solution {
    public String solution(String phone) {
        
        char[] ch = phone.toCharArray();
        
        for(int i=0; i<phone.length()-4; i++){
            ch[i] = '*';
        }
        
        return String.valueOf(ch);
    }
}