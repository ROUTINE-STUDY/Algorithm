package BaekJoon.적어도대부분의배수_1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            int[] nums = new int[arr.length];

            for(int i=0; i<arr.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            System.out.println(getMinMultipleNum(nums));
        }
    }

    private static int getMinMultipleNum(int[] nums) {
        // 100보다 작거나 같은 자연수이고 서로 다르기때문에 100 * 99 * 98
        for(int answer=1; answer<970201; answer++) {
            int count = 0;

            for(int num : nums) {
                if(answer % num == 0) {
                    if(++count == 3) {
                        return answer;
                    }
                }
            }
        }

        return 0;
    }

}
