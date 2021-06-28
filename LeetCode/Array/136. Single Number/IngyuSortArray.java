import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        //정렬하고, 두개씩 체크 두칸씩 띄어감
        //1 -> 답 : 1
        //1,1,2,2,4면 1,1, -> 2,2 -> 4 -> 답 : 4
        //1,2,2 -> 1,2
        //1,1,2,3,3,4,4 -> 2,3 -> 
        //1,1,
        //-> 만약 두개씩 비교했을 때 안 같으면 앞에 숫자가 정답.
        //그러면 로직은 앞에서부터 두개씩 i는 배열길이-3까지 i= i+2
        //만약 두개가 안같으면 앞에 숫자가 answer에 대입됨.
        //단 만약에 마지막 숫자가 정답인 경우, 1,1,2,2,3,3,4면 마지막이 정답이 됨.
        //answer을 처입 대입할 때 마지막 값을 넣어주자.
        Arrays.sort(nums);
        int answer = nums[nums.length-1];
        for (int i = 0; i <= nums.length - 3; i+=2) {
            if (nums[i] != nums[i+1]) {
                answer = nums[i];
                break;
            }
        }

        return answer;
    }
}