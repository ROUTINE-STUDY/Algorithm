import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] arr = new int[input];
		
		int count = 0;
		for(int i=0; i<input; i++){
			arr[i] = Integer.parseInt(br.readLine());
			int sqrt = (int)(Math.sqrt(arr[i]));
			if(sqrt * sqrt == arr[i]){
				count++;
			}
		}
		
		System.out.print(count);
	}
}