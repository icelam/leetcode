/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  const hashMap = {}
  nums.forEach((n) => {
    if (hashMap[n]) {
      hashMap[n]++;
    } else {
      hashMap[n] = 1;
    }
  });

  return [...new Set(nums)].find((n) => hashMap[n] === 1);
};
