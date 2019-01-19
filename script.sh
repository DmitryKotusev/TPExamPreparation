echo 'Enter number'
res=0
read res
echo 'Enter file name'
read fileName
res8=$(echo "$res "8" o p" | dc)
echo $res8
digits=${res8:0:3}
echo $digits
ls -l $fileName > file.txt
chmod $res8 $fileName
ls -l $fileName >> file.txt
chmod $((0666 - $(umask))) $fileName
ls -l $fileName >> file.txt

