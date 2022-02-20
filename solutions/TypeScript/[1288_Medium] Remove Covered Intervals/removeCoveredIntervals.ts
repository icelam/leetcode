function insertionSort(arr: number[][]) {
  for (let k = 1; k < arr.length; k++) {
    const key: number[] = arr[k];
    let i: number = k - 1;
    while (i >= 0 && (arr[i][0] > key[0] || (arr[i][0] === key[0] && arr[i][1] < key[1]))) {
      arr[i + 1] = arr[i];
      i--;
    }
    arr[i + 1] = key;
  }
}

function removeCoveredIntervals(intervals: number[][]): number {
  insertionSort(intervals);

  let count = 1;
  let rangeMax = intervals[0][1];

  for (const i of intervals) {
    if (rangeMax < i[1]) {
      count++;
      rangeMax = i[1];
    }
  }

  return count;
}
