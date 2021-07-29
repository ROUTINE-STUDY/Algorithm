package leetcodeLv2;

import java.util.*;

public class kakaoNewId {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
		// 1단계
		new_id = new_id.toLowerCase();
        
		// 2단계
		/* 특수문자 \\ 는 \로 읽는다.  
		 * Invalnew_id escape sequence (해결) 
		 * ^이 [] 안에 있으면 not 을 의미. 
		 * */
		String match2 = "[^-_.a-z0-9]";
		new_id = new_id.replaceAll(match2, "");
		
		// 3단계
		// + : 앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
		String match3 = "[..]+"; 
		new_id = new_id.replaceAll(match3, ".");
        
		// 4단계
		String match4 = "^[.]|[.]$";
		new_id = new_id.replaceAll(match4, "");
        
		// 5단계
		if(new_id.equals("")) {new_id+="a";} // new_id.length() == 0  도 가능
		
		// 6단계
		if(new_id.length() > 15) {
			new_id = new_id.substring(0,15);
            //new_id = new_id.replaceAll("^[.]|[.]$","");
            //정규식 말고 startsWith 메서드와 endsWith 메서드 이용
            if(new_id.startsWith(".")) {
				new_id = new_id.substring(1,15);
			}else if(new_id.endsWith(".")) {
				new_id = new_id.substring(0,14);
			}else if(new_id.startsWith(".") && new_id.endsWith(".")) {
				new_id = new_id.substring(1,14);
			}
		}
		
		// 7단계
		while(new_id.length()<3) {
			new_id += new_id.charAt(new_id.length()-1);
		}
        
		//return new_id;
		
	}
}


