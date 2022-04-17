count=1
while read line  || [[ -n "$line" ]]; do
  if [[ $count -eq 10 ]]; then
    echo "$line"
  fi
  count=$((count+1))
done < "file.txt"
