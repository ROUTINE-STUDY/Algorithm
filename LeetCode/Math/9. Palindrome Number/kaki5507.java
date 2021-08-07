// 첫 번째 방법
class Solution {
    public boolean isPalindrome(int x) {
        String strx = String.valueOf(x);
		
        Stack st = new Stack();
		
        for(int i=0; i<strx.length(); i++) {
	st.push(strx.charAt(i));
        }
		
        String y = "";
        for(int i=0; i<strx.length(); i++) {
	y += st.pop();
        }
        
        return strx.equals(y) ? true : false;
    }
}


// 두 번째 방법
/*
class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
		
        return sb.reverse().toString().equals(x+"") ? true : false;
    }
}
*/