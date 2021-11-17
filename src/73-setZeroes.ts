/**
 Do not return anything, modify matrix in-place instead.
 */
type Address = `${number},${number}`;

function setZeroes(matrix: number[][]): void {
  // handle edge case - empty matrix
  if (!matrix.length) {
    return;
  }

  const matrixWidth = matrix.length > 0 ? matrix[0].length : 0;
  const matrixHeight = matrix.length;

  const zeroValueAddressList: Address[] = [];

  // Loop through matrix values
  for (let y = 0; y < matrixHeight; y++) {
    for (let x = 0; x < matrixWidth; x++) {
      const currentValue = matrix[y][x];
      if (!currentValue) { // if current value is 0
        const address = `${y},${x}` as Address;
        zeroValueAddressList.push(address);
      }
    }
  }

  const rowHashmap: Record<string, number> = {};
  const columnHashmap: Record<string, number> = {};

  zeroValueAddressList.forEach((address) => {
    const [y, x] = address.split(',');
    rowHashmap[y] = rowHashmap[y] ? rowHashmap[y] + 1 : 1;
    columnHashmap[x] = columnHashmap[x] ? columnHashmap[x] + 1 : 1;
  });

  // Set zeros
  const rowsToReset = new Set(Object.keys(rowHashmap));
  const columnsToReset = new Set(Object.keys(columnHashmap));

  rowsToReset.forEach((row) => {
    for(let column = 0; column < matrixWidth ; column++) {
      // console.log("R", row, column)
      matrix[parseInt(row, 10)][column] = 0;
    }
  });

  columnsToReset.forEach((column) => {
    for(let row = 0; row < matrixHeight; row++) {
      // console.log("C", row, column)
      matrix[row][parseInt(column, 10)] = 0;
    }
  });
};
