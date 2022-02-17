function decodeString(s: string): string {
  const stack = [];
  let temp = '';
  let isPrevioisCharNumber = false;
  let bracketsOpened = 0;

  for (const char of s) {
    if (!isPrevioisCharNumber && !bracketsOpened && temp) {
      stack.push(temp);
      temp = '';
    }

    if (char.charCodeAt(0) >= '0'.charCodeAt(0) && char.charCodeAt(0) <= '9'.charCodeAt(0)) {
      isPrevioisCharNumber = true;
    } else if (char === '[') {
      bracketsOpened += 1;
      isPrevioisCharNumber = false;
    } else if (char === ']') {
      bracketsOpened -= 1;
      isPrevioisCharNumber = false;
    }

    temp += char;
  }

  stack.push(temp);

  let result = '';

  for (const part of stack) {
    if (part.includes('[')) {
      const numberOfRepeat = Number(part.substring(0, part.indexOf('[')));
      const substring = part.substring(part.indexOf('[') + 1, part.length - 1);
      result += decodeString(substring).repeat(numberOfRepeat);
    } else {
      result += part.repeat(1);
    }
  }

  return result;
}
