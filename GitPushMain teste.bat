chcp 65001 
echo OFF 
cls 
git add . 
git commit -m "atualização %date%" 
git push origin main 
pause 
