max=$(head -n 1 file.txt | xargs -n 1 | wc -l)
count=1

while [[ "$count" -le "$max" ]]; do
  col=$(awk -v "col=${count}" '{print $col}' file.txt);
  echo ${col}
  count=$((count+1))
done
