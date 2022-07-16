title Clonando um repositorio
echo off
cls


echo Cole o http do projeto aqui
set /p link=
start "" "%PROGRAMFILES%\Git\bin\sh.exe" -c "git clone %link%"