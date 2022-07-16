chcp 65001
echo OFF
cls


git add .
git commit -m "mudei %date%"
git push origin main
echo Press Enter...
read