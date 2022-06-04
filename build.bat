@echo off
cd src/main/java
echo Compiling .java files...
forfiles /S /M *.java /C "cmd /Q /C for %%I in (@relpath) do echo %%~I" > sources.list
javac @sources.list
del sources.list
echo Packing .class files into .jar...
forfiles /S /M *.class /C "cmd /Q /C for %%I in (@relpath) do echo %%~I" > sources.list
forfiles /S /M *.properties /C "cmd /Q /C for %%I in (@relpath) do echo %%~I" >> sources.list
forfiles /S /M *.dll /C "cmd /Q /C for %%I in (@relpath) do echo %%~I" >> sources.list
mkdir ..\..\..\build > nul 2>&1
jar cmf MANIFEST.mf ../../../build/Editor.jar @sources.list
echo Editor.jar has been generated in ./build
del sources.list
cd ../../../
echo Process finished...
pause > nul