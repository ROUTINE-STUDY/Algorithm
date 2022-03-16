class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < 48 || s.charAt(i) > 57){
                return false;
            }
        }
        
        return answer;
    }
}

// 2

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        
        return false;
    }
}

// 3

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            return s.matches("(^[0-9]*$)");
        }
        
        return false;
    }
}
