declare global {
  interface Array<T> {
    snail(rowsCount: number, colsCount: number): number[][];
  }
}

Array.prototype.snail = function (rowsCount: number, colsCount: number): number[][] {
  if (this.length !== rowsCount * colsCount) {
    return [];
  }

  const result: number[][] = Array.from({ length: rowsCount }, () => []);
  let direction = 1;
  let currentRow = 0;
  let currentColumn = 0;

  for (let i = 0; i < this.length; i++) {
    result[currentRow][currentColumn] = this[i];
    currentRow += direction;

    if (currentRow === -1 || currentRow === rowsCount) {
      direction *= -1;
      currentRow += direction;
      currentColumn++;
    }
  }

  return result;
}
