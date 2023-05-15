function chunk(arr: any[], size: number): any[][] {
  const result: any[] = [];
  let arrayChunk: any[] = [];

  for (let i = 0; i < arr.length; i++) {
    arrayChunk.push(arr[i]);

    if (arrayChunk.length === size || i === arr.length - 1) {
      result.push(arrayChunk);
      arrayChunk = [];
    }
  }

  return result;
}
