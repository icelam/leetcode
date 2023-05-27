type MultidimensionalArray = (MultidimensionalArray | number)[]

const isNumber = (arr: unknown): arr is number => typeof arr === 'number';

function* inorderTraversal(arr: MultidimensionalArray): Generator<number, void, unknown> {
  for (const value of arr) {
    if (isNumber(value)) {
      yield value;
      continue;
    }

    yield* inorderTraversal(value);
  }
}
