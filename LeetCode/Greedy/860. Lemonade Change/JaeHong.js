var lemonadeChange = function (bills) {
  var count5 = 0;
  var count10 = 0;

  for (var i = 0; i < bills.length; i++) {
    if (bills[i] === 5) {
      count5++;
    } else if (bills[i] === 10) {
      count10++;
    }
    if (bills[i] === 10) {
      if (count5 === 0) {
        return false;
      } else {
        count5--;
      }
    } else if (bills[i] === 20) {
      if (count5 >= 1 && count10 >= 1) {
        count5--;
        count10--;
      } else if (count5 >= 3) {
        count5 -= 3;
      } else {
        return false;
      }
    }
  }
  return true;
};
