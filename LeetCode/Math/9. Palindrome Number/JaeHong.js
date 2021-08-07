var isPalindrome = function (x) {
  const palindromeNumber = x.toString().split('').reverse().join('');
  return (result = x == palindromeNumber ? true : false);
};
