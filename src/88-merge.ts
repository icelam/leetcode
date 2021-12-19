function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  if (n === 0) {
    return;
  }

  for (let i = 0; i < n; i++) {
    nums1[m + i] = nums2[i];
  }

  if(m === 0) {
    return;
  }

  for (let i = nums1.length - 1; i >= 0; i--) {
    for (let j = i - 1; j >= 0; j--) {
      if (nums1[j] > nums1[i]) {
        let temp = nums1[i];
        nums1[i] = nums1[j];
        nums1[j] = temp;
      }
    }
  }
};
