function titleToNumber(columnTitle: string): number {
  let sum = 0;
  for (let i = columnTitle.length - 1, j = 0; i >= 0; i--, j++) {
    sum += (columnTitle.charCodeAt(i) - 64) * Math.pow(26, j);
  }
  return sum;
}
