package Array.Majority_Element;

import java.util.Arrays;

public class Sanghoo {

    // 리팩토링하며 떠오른 방법
    // majorityElement > nums.length/2 성질을 생각하다가 발견.. 정렬을 한다면 nums.length/2의 인덱스에 있는 값은 무조건 majorityElement가 아니한가?
    public static int majorityElement(int[] nums) {
        int res = 0;

        // 원소가 1개이거나 2개이면 무조건 존재하는 원소가 majorityElement
        if(nums.length <= 2) return nums[0];

        // 정렬 후 가운데 값은 무조건 최대 원소
        Arrays.sort(nums);
        res = nums[nums.length / 2];

        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{-1,100,2,100,100,4,100}));
    }
}
