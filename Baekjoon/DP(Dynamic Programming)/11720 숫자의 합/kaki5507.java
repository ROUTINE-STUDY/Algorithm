package back23y02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberHan {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		int answer = 0;
		
		for(int i=0; i<num; i++) {
			answer += str.charAt(i)-48;
		}
		System.out.println(answer);
	}

}
