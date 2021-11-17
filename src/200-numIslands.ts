type Tile = number | undefined;

function numIslands(map: string[][]): number {
  // handle edge case - empty map
  if (!map.length) {
    return 0;
  }

  const mapProperties = {
    width: map.length > 0 ? map[0].length : 0,
    height: map.length
  };

  // store the tile id and it's island index
  const tileHashmap: Record<string, number> = {};

  let helperCounter = 0;

  // Loop through tiles
  for (let y = 0; y < mapProperties.height; y++) {
    for (let x = 0; x < mapProperties.width; x++) {
      const currentTile = map[y][x];

      if (currentTile === "1") { // if current tile is land (land === 1)
        const tileId = `${y},${x}`;

        const upperTile: Tile = parseInt(map[y - 1]?.[x], 10);
        const leftTile: Tile = parseInt(map[y]?.[x - 1], 10);

        // if up and left tile is empty, then it
        // have a chance that this is a new island
        if (!upperTile && !leftTile) {
          helperCounter++;
          tileHashmap[tileId] = helperCounter;
        } else {
          const upperTileIslandIndex = tileHashmap[`${y - 1},${x}`];
          const leftTileIslandIndex = tileHashmap[`${y},${x - 1}`];

          if (upperTile && leftTile) {
            // if both up and left tile is land (island)
            // and the current tile is a joint tile of both land
            // perform a merge on lands (island)
            if (upperTileIslandIndex !== leftTileIslandIndex) {
              for (let searchingTileId in tileHashmap) {
                if (tileHashmap[searchingTileId] === leftTileIslandIndex) {
                  tileHashmap[searchingTileId] = upperTileIslandIndex;
                }
              }
            }
            tileHashmap[tileId] = upperTileIslandIndex;
          } else if (upperTile) { // this tile is connected with the upper tile
            tileHashmap[tileId] = upperTileIslandIndex;
          } else if (leftTile) { // this tile connects with the left tile
            tileHashmap[tileId] = leftTileIslandIndex;
          }
        }
      }
    }
  }

  // Return the result
  return new Set(Object.values(tileHashmap)).size;
};
