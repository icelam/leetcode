const twoSum = (numberList: number[], target: number): number[] => {
  let result: number[] = [];

  const hashmap: Record<number, number> = {};

  for (let i = 0; i < numberList.length; i++) {
    const currentValue = numberList[i];
    if(hashmap[target - currentValue] >= 0) {
      result = [hashmap[target - currentValue], i];
      break;
    } else {
      hashmap[currentValue] = i;
    }
  }

  return result;
};
