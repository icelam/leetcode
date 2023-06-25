function sortBy(arr: any[], fn: Function): any[] {
  const copiedArr = [...arr];

  copiedArr.sort((a, b) => {
    const c = fn(a);
    const d = fn(b);

    if (c > d) {
      return 1;
    }

    if (c < d) {
      return -1;
    }

    return 0;
  });

  return copiedArr;
}
