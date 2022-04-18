/**
 Do not return anything, modify matrix in-place instead.
 */

function setZeroes(matrix: number[][]): void {
  const rowSize: number = matrix.length;
  const columnSize: number = matrix[0].length;
  const rowsToReset = new Set<number>();
  const columnsToReset = new Set<number>();

  for (let i = 0; i < rowSize; i++) {
    for (let j = 0; j < columnSize; j++) {
      if (matrix[i][j] == 0) {
        rowsToReset.add(i);
        columnsToReset.add(j);
      }
    }
  }

  rowsToReset.forEach((row) => {
    for (let column = 0; column < columnSize; column++) {
      matrix[row][column] = 0;
    }
  });

  columnsToReset.forEach((column) => {
    for (let row = 0; row < rowSize; row++) {
      matrix[row][column] = 0;
    }
  });
}
