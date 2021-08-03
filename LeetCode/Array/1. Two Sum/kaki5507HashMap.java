package leetcodeLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class twosum {

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };
		int target = 9;

		// 보수를 구하는게 이 문제의 핵심
		// 보수의 값을 키 값으로 둔다.
		// 키 값이 map에 있으면 ?
		// 0번에 i값을 두고 키 값이 있는 그 위치 밸류를 반환한다.

		int dab[] = new int[2];

		HashMap<Integer, Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			int comp = target - nums[i]; // 보수
			if (map.containsKey(nums[i])) {
				dab[0] = i;
				dab[1] = map.get(nums[i]);
			}
			map.put(comp, i);
		}
//		return dab;

	}

}
