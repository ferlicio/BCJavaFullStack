chcp 65001
echo OFF
cls

start "" "%PROGRAMFILES%\Git\bin\sh.exe" -c "git add . && git commit -m "atualização %date%" && git push origin main; bash"