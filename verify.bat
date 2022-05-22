@echo off
del /S *.class > nul 2>&1
cd src/main/java
echo Compiling .java files...
forfiles /S /M *.java /C "cmd /Q /C for %%I in (@relpath) do echo %%~I" > sources.list
javac @sources.list
del sources.list
echo Process finished...
pause > nul