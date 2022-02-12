function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
  // Use include for simplicity, O(n)
  if (!wordList.includes(endWord)) {
    return 0;
  }

  let visited = { [beginWord]: 1 };
  let queue = [beginWord];
  let word;

  while (word = queue.pop()) {
    if (word === endWord) {
      break;
    }

    for (let newWord of wordList) {
      let differenceCount = 0;

      for (let i = 0; i < word.length; i++) {
        if (word[i] !== newWord[i]) {
          differenceCount++;
        }
      }

      if (differenceCount === 1 && !visited[newWord]) {
        visited[newWord] = visited[word] + 1;
        queue.unshift(newWord);
      }
    }
  }

  return visited[endWord] ?? 0;
};

// const beginWord = "leet", endWord = "code", wordList = ["lest","lose","code","lode","robe","lost"];
const beginWord = "qa";
const endWord = "sq";
const wordList = ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"];
console.log(ladderLength(beginWord, endWord, wordList));
