import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(bf.readLine());
		int answer = 0;
		
		while(true) {
			if(sugar == 4 || sugar == 7 || sugar == 1 || sugar == 2) {
				answer = -1;
				break;
			}
			if(sugar % 5 == 0) {
				answer += sugar / 5;
				break;
			}else { // 안나눠 떨어지면 -3 해서 횟수 증가 시키고 5로 다시 나눔 근데 그게 4나 7이면 
				sugar-=3;
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}