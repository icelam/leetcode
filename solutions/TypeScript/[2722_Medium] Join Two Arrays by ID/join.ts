function join(arr1: any[], arr2: any[]): any[] {
  const map: Record<number, any[]> = {};

  for (const record of arr1) {
    map[record.id] = [...(map[record.id] ?? []), record];
  }

  for (const record of arr2) {
    map[record.id] = [...(map[record.id] ?? []), record];
  }

  const result: any[] = [];
  Object.keys(map).forEach((id) => {
    result.push({ ...map[id][0], ...map[id][1] });
  });

  result.sort((a, b) => (a.id > b.id ? 1 : a.id < b.id ? -1 : 0));

  return result;
}
