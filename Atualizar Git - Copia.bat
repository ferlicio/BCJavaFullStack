chcp 65001
echo OFF
cls

#!/bin/sh
git checkout dev
git add .
git commit -am "made changes"
git push
echo Press Enter...
read