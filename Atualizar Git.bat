chcp 65001
echo OFF
cls


echo coloque a senha para atualizar o repositório do Git
set /p senha=
	if %senha% NEQ 91378250 exit
git add .
git commit -m "atualização %date%"
git push origin main
