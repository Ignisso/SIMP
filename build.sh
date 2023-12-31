#!/bin/sh
cd "src/main/java"
echo "Compiling .java files ..."
for f in $(find . -name "*.java"); do 
	echo $f >> sources.list
done
javac @sources.list
rm sources.list
echo "Packing .class files into .jar..."
for f in $(find . -name "*.class"); do 
	echo $f >> sources.list
done
jar cmf MANIFEST.mf ../../../build/Editor.jar @sources.list
echo "Editor.jar jas been generated in ./build"
rm sources.list
cd ../../
