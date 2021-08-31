class Solution {
    public int solution(String s) {
        int size = s.length();
        int i=0;
        
        String tmp = "";
        while(i<size){
            if(s.charAt(i) > 47 && s.charAt(i) < 58){
                tmp+=s.charAt(i);
                i++;
            }else if(s.charAt(i) == 122){
                tmp+="0";
                i+=4;
            }else if(s.charAt(i) == 111){
                tmp+="1";
                i+=3;
            }else if(s.charAt(i) == 101){
                tmp+="8";
                i+=5;
            }else if(s.charAt(i) == 110){
                tmp+="9";
                i+=4;
            }else if(s.charAt(i) == 116){
                if(s.charAt(i+1) == 119){ // w 119
                    tmp+="2";
                    i+=3;
                }else{
                    tmp+="3";
                    i+=5;
                }
            }else if(s.charAt(i) == 102){
                if(s.charAt(i+1) == 111){
                    tmp+="4";
                    i+=4;
                }else{
                    tmp+="5";
                    i+=4;
                }
            }else if(s.charAt(i) == 115){
                if(s.charAt(i+1) == 105){
                    tmp+="6";
                    i+=3;
                }else{
                    tmp+="7";
                    i+=5;
                }
            }
        }
        int answer = Integer.parseInt(tmp);
        
        return answer;
    }
}