declare global {
    interface Array<T> {
        groupBy(fn: (item: T) => string): Record<string, T[]>
    }
}

Array.prototype.groupBy = function (fn) {
  const map: Record<string, any> = {};
  for (const row of this) {
    const key = fn(row);
    if (!map[key]) {
      map[key] = [];
    }
    map[key].push(row);
  }

  return map;
};
