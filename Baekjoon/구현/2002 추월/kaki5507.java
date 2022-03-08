package back22y03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class overTake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int carCnt = Integer.parseInt(bf.readLine());
		int answer = 0; // 정답
		HashMap<String, Integer> map = new HashMap();
		
		for(int i=0; i<carCnt; i++) {
			String inputCar = bf.readLine();
			map.put(inputCar, i);
		}
		
		int[] outputCar = new int[carCnt];
		
		for(int i=0; i<carCnt; i++) {
			String input = bf.readLine();
			outputCar[i] = map.get(input); //들어갔던 차, 몇번째 들어갔는지 outputCar에 담아준다
		}
		System.out.println(map);
		System.out.println(Arrays.toString(outputCar));
		
		for(int i=0; i<carCnt; i++) {
			for(int j=i+1; j<carCnt; j++) { // 이미 나간 차 비교 할 필요 없음
				if(outputCar[i] > outputCar[j]) { //들어갔던차가 먼저 들어간 차 보다 빨리 나왔으면
					answer++;	// 증가시키고 
					break;		// 끝내고 다음 차 비교한다.
				}
			}
		}
		System.out.println(answer);
	}

}
