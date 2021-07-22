package leetcode;

public class Lengthofword {

	public static void main(String[] args) {
		String s= "Hello worldss";
		String s3="     ";
		String s6 ="a ";
		
		System.out.println(s6.length());
//		trim() 바깥의 공백 잘라줌
//		lastIndexOf로 뒤에서 찾아주고 -> 왼쪽부터 셈
//		String a = s.substring(s.trim().lastIndexOf(" ")-1,s.trim().length());
//		System.out.println(a.trim().length());
		
		
        String str[] = s.split(" ");
        
        if(str.length == 0) {
        	System.out.println(0);
        }else
            System.out.println(str[str.length-1].length());
        
	}

}
