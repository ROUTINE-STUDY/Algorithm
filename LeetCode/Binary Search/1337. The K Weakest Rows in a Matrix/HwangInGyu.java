import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] soldiersNumArr = new int[mat.length];
        int[] answer = new int[k];
        for (int i = 0; i < mat.length; i++) {
            int soldierNum = checkNumofSoldier(mat[i]);
            map.put(i,soldierNum);
            soldiersNumArr[i] = soldierNum;
        }
        Arrays.sort(soldiersNumArr);

        for (int i = 0; i < k; i++) {
            answer[i] = getKeyByValue(map, soldiersNumArr[i]);
        }

        return answer;
    }
    private int checkNumofSoldier(int[] ints) {
        int left = 0;
        int right = ints.length-1;
        int index = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (ints[mid] == 0) {
                right = mid - 1;
            } else {
                index = Math.max(index, mid);
                left = mid + 1;
            }
        }

        return index+1;
    }

    private int getKeyByValue(Map<Integer, Integer> map, int value) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (map.get(key) == value) {
                map.remove(key);
                return key;
            }
        }

        return -1;
    }
}