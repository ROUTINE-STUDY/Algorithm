class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // str2가 null(빌 때)까지 반복문을 돌려줍니다.
        while(!str2.isEmpty()){
            // str2가 더 큰 값이면 바꿔줍니다. str1한테 더 큰값이 들어감.
            if(str2.length() > str1.length()){
                String tmp="";
                tmp = str1;
                str1 = str2;
                str2 = tmp;
            }
            
            //str2의 문자열까지 str1의 문자열도 똑같다면 
            if(str1.substring(0,str2.length()).equals(str2)){
                String r = str1.substring(str2.length());
                str1 = str2;
                str2 = r;
            }else{
                return "";
            }
        }
        
        return str1;
    }
}