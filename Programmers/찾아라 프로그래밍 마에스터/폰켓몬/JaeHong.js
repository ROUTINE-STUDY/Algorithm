function solution(nums) {
  const arr = new Set(nums);

  if (nums.length / 2 > arr.size) {
    return arr.size;
  } else {
    return nums.length / 2;
  }
}
