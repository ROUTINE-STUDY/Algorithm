var maximum69Number = function (num) {
  var str = num.toString();
  var res = str.replace('6', '9');
  return Number(res);
};
