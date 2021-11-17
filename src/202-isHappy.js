/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
  var hashMap = {};
  var squaresSum = n;

  while (squaresSum !== 1) {
    var nums = String(squaresSum).split('');
    squaresSum = nums.reduce((i, n) => (Math.pow(n, 2) + i), 0);

    if (hashMap[squaresSum]) {
      return false;
    }

    hashMap[squaresSum] = 1;
  }

  return true;
};
