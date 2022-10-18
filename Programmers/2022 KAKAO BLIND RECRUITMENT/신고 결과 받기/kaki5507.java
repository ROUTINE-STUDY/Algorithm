import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class reportResult {

	public static void main(String[] args) {
		//String[] id_list, String[] report, int k
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] retMail = new int[id_list.length]; // 받을 메일 횟수
		HashMap<String,Integer> reportMap = new HashMap<>();
		HashMap<String,HashSet<String>> reportMapNum = new HashMap<>();
		
		// 맵 세팅
		for(int i=0; i<id_list.length; i++) {
			reportMap.put(id_list[i], i);
			reportMapNum.put(id_list[i], new HashSet<String>());
		}
		
		// 보내는 사람 se 받는 사람 re
		for(int i=0; i<report.length; i++) {
			String[] split = report[i].split(" "); // 띄어쓰기로 구분
			String se = split[0];
			String re = split[1];
			reportMapNum.get(re).add(se);
		}
	
		for(int i=0; i<id_list.length; i++) {
			 HashSet<String> set = reportMapNum.get(id_list[i]);
			 if(set.size() >= k) {
				 for(String userid : set) {
					 retMail[reportMap.get(userid)]++;					 
				 }
			 }
		}
		
		System.out.println(Arrays.toString(retMail));
		
	}

}