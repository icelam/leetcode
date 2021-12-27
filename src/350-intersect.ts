function intersect(nums1: number[], nums2: number[]): number[] {
  const hashmap1: Record<string, number> = {};
  const hashmap2: Record<string, number> = {};

  let result: number[] = [];

  for (let i = 0; i < Math.max(nums1.length, nums2.length); i++) {
    if (i < nums1.length) {
      hashmap1[String(nums1[i])] = (hashmap1[nums1[i]] ?? 0) + 1;
    }

    if (i < nums2.length) {
      hashmap2[String(nums2[i])] = (hashmap2[nums2[i]] ?? 0) + 1;
    }
  }

  (
    Object.keys(hashmap1).length > Object.keys(hashmap2).length
      ? Object.keys(hashmap1)
      : Object.keys(hashmap2)
  ).forEach((key) => {
    const intersectCount = Math.min(hashmap1[key] ?? 0, hashmap2[key] ?? 0);

    for (let j = 0; j < intersectCount; j++) {
      result.push(Number(key));
    }
  });

  return result;
};
