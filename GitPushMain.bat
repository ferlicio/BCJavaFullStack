chcp 65001
echo OFF
cls


REM echo coloque a senha para atualizar o repositório do Git
REM set /p senha=
REM 	if %senha% NEQ 91378250 GOTO senhaerrada
REM ================================================================

git add .
git commit -m "atualização %date%"
git push origin main


REM :senhaerrada
REM cls
REM echo senha errada...
REM @pause