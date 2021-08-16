class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        recursion(numbers, 0, target);
        return answer;
    }

    public void recursion(int[] numbers, int index, int target) {
        if (index == numbers.length) {
            if (target == 0) answer++;
            return;
        }
        // 숫자를 + 로 주는 경우
        recursion(numbers, index+1, target - numbers[index]);
        // 숫자를 - 로 주는 경우
        recursion(numbers, index+1,  target + numbers[index]);
    }
}