function numIslands(grid: string[][]): number {
  const height = grid.length;
  const width = grid[0].length;

  const isValidPosition = (
    y: number,
    x: number
  ): boolean => (
    y >= 0 && y < height && x >= 0 && x < width
  );

  const visitIsland = (
    y: number,
    x: number
  ): void => {
    if (!isValidPosition(y, x) || grid[y][x] === '0') {
      return;
    }

    grid[y][x] = '0';

    visitIsland(y + 1, x);
    visitIsland(y - 1, x);
    visitIsland(y, x + 1);
    visitIsland(y, x - 1);
  };

  let result = 0;

  for (let y = 0; y < height; y++) {
    for (let x = 0; x < width; x++) {
      if (grid[y][x] === '1') {
        result++;
        visitIsland(y, x);
      }
    }
  }

  return result;
}
