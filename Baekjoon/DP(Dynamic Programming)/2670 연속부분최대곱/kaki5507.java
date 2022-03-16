package back22y03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class seqNumber {
	
	// double을 바꿔주는 dStr
	public static double dStr(String str) {
		return Double.parseDouble(str);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		
		double[] dArr = new double[num];
		for(int i=0; i<num; i++) {
			dArr[i] = dStr(bf.readLine());
		}
		
		double max = dArr[0];
		
		for(int i=1; i<num; i++) {
			dArr[i] = Math.max(dArr[i], dArr[i-1] * dArr[i]); // 현재 위치에서 연속된 값 중 큰 값
			System.out.println("dArr[i] : " + dArr[i] + " i가 : " + i + "  ,max : " + max);
			max = Math.max(max,dArr[i]); // 연속된 곱에서 제일 큰 값
		}
		
		System.out.printf("%.3f", max);
	}

}