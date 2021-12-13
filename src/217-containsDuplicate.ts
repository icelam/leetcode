function containsDuplicate(nums: number[]): boolean {
  const hashmap: Record<number, number> = {};

  for (let n of nums) {
    if (hashmap[n])
      return true;

    hashmap[n] = 1;
  }

  return false;
};
