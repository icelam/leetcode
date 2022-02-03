function matrixReshape(mat: number[][], row: number, column: number): number[][] {
  const originalRowCount = mat.length;
  const originalColumnCount = mat[0].length;

  if (
    (originalRowCount === row && originalColumnCount === column)
    || (originalRowCount * originalColumnCount !== row * column)
  ) {
    return mat;
  }

  let currentRow = 0;
  let currentColumn = 0;
  
  const result:number[][] = [];

  for(let i = 0; i < row; i++) {
    let newRow: number[] = [];

    for(let j = 0; j < column; j++) {
      newRow.push(mat[currentRow][currentColumn]);

      currentColumn++;

      if (currentColumn === originalColumnCount) {
        currentRow++;
        currentColumn = 0;
      }
    }

    result.push(newRow);
  }

  return result;
}
