function quickSort(arr: number[]) {
  function swap(items: number [], leftIndex: number, rightIndex: number) {
    const temp = items[leftIndex];
    items[leftIndex] = items[rightIndex];
    items[rightIndex] = temp;
  }

  function partition(items: number [], left: number, right: number) {
    const pivot = items[Math.floor((right + left) / 2)];
    let i = left;
    let j = right;

    while (i <= j) {
      while (items[i] < pivot) {
        i++;
      }
      while (items[j] > pivot) {
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

  function sort(items: number [], left: number, right: number) {
    let index: number;

    if (items.length > 1) {
      index = partition(items, left, right);
      if (left < index - 1) {
        sort(items, left, index - 1);
      }
      if (index < right) {
        sort(items, index, right);
      }
    }

    return items;
  }

  return sort(arr, 0, arr.length - 1);
}

function minimumAbsDifference(arr: number[]): number[][] {
  quickSort(arr);

  // find pairs
  let minDifference;
  let result: number[][] = [];
  for(let i = 0; i < arr.length - 1; ++i) {
    if (!minDifference || arr[i + 1] - arr[i] < minDifference) {
      minDifference = arr[i + 1] - arr[i];
      result.length = 0;
      result.push([arr[i], arr[i + 1]])
    } else if(arr[i + 1] - arr[i] === minDifference) {
      result.push([arr[i], arr[i + 1]])
    }
  }

  return result;
}
