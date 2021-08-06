package leetcodeLv2;

import java.util.Stack;

public class MaximumNesting {

	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();

		String s = "(1+(2*3)+((8)/4))+1";
		
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				st.push("(");
			}else if(s.charAt(i) == ')') {
				st.pop();
			}
			count = Math.max(count, st.size());
		}
		System.out.println(count);
	}

}
