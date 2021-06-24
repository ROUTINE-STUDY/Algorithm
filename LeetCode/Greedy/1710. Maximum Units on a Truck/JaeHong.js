var maximumUnits = function (boxTypes, truckSize) {
  boxTypes.sort((a, b) => b[1] - a[1]);

  let units = 0;

  for (const [boxes, boxUnits] of boxTypes) {
    if (truckSize === 0) return units;
    const boxesToPlace = Math.min(truckSize, boxes);
    truckSize -= boxesToPlace;
    units += boxesToPlace * boxUnits;
  }

  return units;
};

console.log(
  maximumUnits(
    [
      [5, 10],
      [2, 5],
      [4, 7],
      [3, 9],
    ],
    10
  )
);
