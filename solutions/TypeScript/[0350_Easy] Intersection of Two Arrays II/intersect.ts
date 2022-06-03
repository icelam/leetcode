function intersect(nums1: number[], nums2: number[]): number[] {
  const map: Record<number, number> = {};
  const result: number[] = [];

  for (const m of nums1) {
    map[m] = (map[m] ?? 0) + 1;
  }

  for (const n of nums2) {
    if ((map[n] ?? 0) > 0) {
      result.push(n);
      map[n] -= 1;
    }
  }

  return result;
}
