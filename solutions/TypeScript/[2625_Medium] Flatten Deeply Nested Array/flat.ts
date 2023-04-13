type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr: MultiDimensionalArray, n: number): MultiDimensionalArray {
  const result:MultiDimensionalArray = [];

  for (const value of arr) {
    if (Array.isArray(value) && n > 0) {
      result.push(...flat(value, n - 1));
    } else {
      result.push(value);
    }
  }

  return result;
};
