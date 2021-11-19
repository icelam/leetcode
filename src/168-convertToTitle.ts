function toColumnChar (code: number) {
  return String.fromCharCode((code || 26) + 64);
}

function convertToTitle(columnNumber: number): string {
  let remain = columnNumber;
  let result = '';

  while (remain > 0) {
    // Handle 52 = AZ, 676 = YZ, 702 = ZZ
    if (remain % 26 === 0) {
      result = toColumnChar(26) + result;
      remain = Math.floor(remain / 26) - 1;
    } else {
      result = toColumnChar(Math.floor(remain % 26)) + result;
      remain = Math.floor(remain / 26);
    }
  }

  return result;
};
