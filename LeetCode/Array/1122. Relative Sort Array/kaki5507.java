import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int a1 = arr1.length;
        int a2 = arr2.length;
        
        // arr1의 크기와 같게
        int answer[] = new int[a1];
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int i : arr1) map.put(i,map.getOrDefault(i,0)+1);

		int tmp = 0;
		for (int i = 0; i < a2; i++) {
			for (int j = 0; j < a1; j++) {
				if (arr2[i] == arr1[j]) {
					answer[tmp++] = arr1[j];
					map.remove(arr2[i]);
				}
			}
		}
		
		ArrayList<Integer> nam = new ArrayList();
		for(Map.Entry <Integer, Integer> entry : map.entrySet()) {
			for(int i=0; i<entry.getValue(); i++) {
				nam.add(entry.getKey());
			}
		}
		
		Collections.sort(nam);
		
		for(int i=0; i<nam.size(); i++) {
			answer[tmp++] = nam.get(i);
		}
        
        return answer;
    }
}