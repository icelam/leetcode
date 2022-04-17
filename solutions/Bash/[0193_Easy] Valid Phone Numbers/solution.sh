while read line  || [[ -n "$line" ]]; do
  if [[ $line =~ ^\([0-9]{3}\)\ [0-9]{3}\-[0-9]{4}$ ]] || [[ $line =~ ^[0-9]{3}\-[0-9]{3}\-[0-9]{4}$ ]]; then
    echo "$line"
  fi
done < "file.txt"
