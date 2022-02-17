function quickSort(arr: number[][]) {
  function swap(items: number [][], leftIndex: number, rightIndex: number) {
    const temp = items[leftIndex];
    items[leftIndex] = items[rightIndex];
    items[rightIndex] = temp;
  }

  function partition(items: number [][], left: number, right: number) {
    const pivot = items[Math.floor((right + left) / 2)][0];
    let i = left;
    let j = right;

    while (i <= j) {
      while (items[i][0] < pivot) {
        i++;
      }
      while (items[j][0] > pivot) {
        j--;
      }
      if (i <= j) {
        swap(items, i, j);
        i++;
        j--;
      }
    }
    return i;
  }

  function sort(items: number [][], left: number, right: number) {
    let index: number;

    if (items.length > 1) {
      index = partition(items, left, right); // index returned from partition
      if (left < index - 1) { // more elements on the left side of the pivot
        sort(items, left, index - 1);
      }
      if (index < right) { // more elements on the right side of the pivot
        sort(items, index, right);
      }
    }

    return items;
  }

  return sort(arr, 0, arr.length - 1);
}

function merge(intervals: number[][]): number[][] {
  quickSort(intervals);

  let min = intervals[0][0];
  let max = intervals[0][1];

  const result: number[][] = [];

  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] <= max) {
      min = Math.min(min, intervals[i][0]);
      max = Math.max(max, intervals[i][1]);
    } else {
      result.push([min, max]);
      min = intervals[i][0];
      max = intervals[i][1];
    }
  }

  result.push([min, max]);

  return result;
}
